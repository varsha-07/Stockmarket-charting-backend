package com.varsha.company.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockPriceDto {
	
	@Id
	private String id;
	
	private String companyCode;
	private String stockExchange;
	private double currentPrice;
	private String date;
	private String time;
	

}
