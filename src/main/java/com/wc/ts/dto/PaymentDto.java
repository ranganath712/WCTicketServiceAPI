package com.wc.ts.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	
	
	private Integer paymentId;
	
	private String pnr;
	
	private String status;
	
	private Integer passengerId;
	
	private Double price;

	
}
