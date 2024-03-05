package com.wc.ts.service;

import com.wc.ts.dto.TransactionRequest;
import com.wc.ts.dto.TransactionResponse;

public interface TicketService {
	
	public TransactionResponse bookTicket(TransactionRequest request);
	
	//public TransactionResponse getTicket(TransactionRequest request);

}
