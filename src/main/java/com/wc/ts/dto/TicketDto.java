package com.wc.ts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

	
	private Integer passengerId;
	
	private String passengerName;
	
	private String source;
	
	private String destination;
	
	private String coach;
	
	private Double fare;
	
	
}
