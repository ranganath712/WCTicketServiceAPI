package com.wc.ts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ticket_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passengerId;
	
	private String passengerName;
	
	private String source;
	
	private String destination;
	
	private String coach;
	
	private Double fare;
	
	
}
