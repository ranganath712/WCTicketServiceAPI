package com.wc.ts.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.wc.ts.config.ShortCutProperties;
import com.wc.ts.dto.PaymentDto;
import com.wc.ts.dto.TicketDto;
import com.wc.ts.dto.TransactionRequest;
import com.wc.ts.dto.TransactionResponse;
import com.wc.ts.entity.Ticket;
import com.wc.ts.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	private RestTemplate restTemplate;
	
	private TicketRepository ticketRepository;
	
	private ShortCutProperties properties;
	
	
	


	public TicketServiceImpl(RestTemplate restTemplate, TicketRepository ticketRepository,
			ShortCutProperties properties) {
		this.restTemplate = restTemplate;
		this.ticketRepository = ticketRepository;
		this.properties = properties;
	}





	@Override
	public TransactionResponse bookTicket(TransactionRequest request) {
		Map<String, String> urls = properties.getUrls();
		String bookResp = urls.get("bookPayUrl");
		String response = "";
		TicketDto passengerInfo = request.getPassenger();
		PaymentDto paymentInfo = request.getPayment();
		paymentInfo.setPassengerId(passengerInfo.getPassengerId());
		paymentInfo.setPrice(passengerInfo.getFare());
		//API Call using rest template
		
		//PaymentDto paymentResponse = restTemplate.postForObject("http://localhost:8081/payments/pay", paymentInfo, PaymentDto.class);
		
		//API call using Web Client
		PaymentDto paymentResponse = WebClient
			.create()
			.post()
			.uri(bookResp)
			.bodyValue(paymentInfo)
			.retrieve()
			.bodyToMono(PaymentDto.class)
			.block();
		response = paymentResponse.getStatus().equals("success")?"Payment success, Ticket will be processed in a few mins":"Failure in payment, please retry later";
		Ticket passengerEntity = new Ticket();
		BeanUtils.copyProperties(passengerInfo, passengerEntity);
		ticketRepository.save(passengerEntity);
		return TransactionResponse
				.builder()
				.passenger(passengerInfo)
				.pnr(paymentResponse.getPnr())
				.fare(paymentResponse.getPrice())
				.msg(response)
				.build();
	}


//	@Override
//	public TransactionResponse getTicket(TransactionRequest request) {
//		TicketDto passengerInfo = request.getPassenger();
//		PaymentDto paymentInfo = request.getPayment();
//		
//		WebClient
//		.create("http://localhost:8081")
//		.get()
//		.uri("payments/get")
//		.
//		return null;
//	}

}
