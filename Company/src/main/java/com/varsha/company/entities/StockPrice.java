package com.varsha.company.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class StockPrice {
	
	@Id
	private String id;
	
	private String companyCode;
	private String stockExchange;
	private double currentPrice;
	private String date;
	private String time;
	
}
