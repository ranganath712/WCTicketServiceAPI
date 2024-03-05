package com.wc.ts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

	private TicketDto passenger;
	
	private String pnr;
	
	private Double fare;
	
	private String msg;
}
