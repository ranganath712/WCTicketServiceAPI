package com.wc.ts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wc.ts.dto.TransactionRequest;
import com.wc.ts.dto.TransactionResponse;
import com.wc.ts.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@PostMapping("/book")
	public TransactionResponse bookTicket(@RequestBody TransactionRequest request) {
		return ticketService.bookTicket(request);
	}
}
