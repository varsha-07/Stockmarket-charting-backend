package com.varsha.sector.entities;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Company {
	@Id
	private String id = UUID.randomUUID().toString();

	private String companyName;
	private String turnover;
	private String ceo;
	private String boardOfDirectors;
	private String listOfStockExchanges;
	private String sector;
	private String writeUp;
	private String stockCode;
	private boolean active;
}
