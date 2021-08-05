package com.varsha.company.entities;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Ipo {
	
	@Id
	private String id=UUID.randomUUID().toString();
	
	private String companyName;
	private String stockExchange;
	private double pricePerShare;
	private int totalShares;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private String openDateTime;
	
	private String remarks;

}
