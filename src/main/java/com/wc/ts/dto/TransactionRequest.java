package com.wc.ts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
	
	private TicketDto passenger;
	
	private PaymentDto payment;
}
