package com.varsha.stockexchange.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockExchangeDto {

	@Id
	private String id;

	private String stockExchange;
	private String writeUp;
	private String contactAddress;
	private String remarks;

}
