package com.varsha.stockprice.entities;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value="stock_price")
public class StockPrice {

	@Id
	private String id = UUID.randomUUID().toString();

	private String companyCode;
	private String stockExchange;
	private double currentPrice;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date date;
	
	@DateTimeFormat(pattern = "HH:mm:ss")
	private String time;

}