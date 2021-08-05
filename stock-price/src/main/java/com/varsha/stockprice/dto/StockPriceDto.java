package com.varsha.stockprice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

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

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String date;
	private String time;

}
