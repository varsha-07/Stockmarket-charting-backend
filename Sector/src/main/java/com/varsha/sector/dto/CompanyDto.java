package com.varsha.sector.dto;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyDto {
	@Id
	private String id;

	private String companyName;
	private String turnover;
	private String ceo;
	private String boardOfDirectors;
	private String listOfStockExchanges;
	private String sector;
	private String writeUp;
	private String stockCode;

	@JsonIgnore
	private boolean active;
}
