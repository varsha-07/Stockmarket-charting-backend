package com.varsha.company.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IpoDto {

	@Id
	private String id;
	
	private String companyName;
	private String stockExchange;
	private double pricePerShare;
	private int totalShares;
	private String openDateTime;
	private String remarks;

}
