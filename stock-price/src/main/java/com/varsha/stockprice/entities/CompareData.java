package com.varsha.stockprice.entities;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(value="compare")
public class CompareData {
	
	@Id
	private String id = "1";
	private Set keys;
	private Collection<Double> sum;

}
