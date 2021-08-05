package com.varsha.company.entities;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sector {
	
	@Id
	private String id;
	
	private String sectorName;
	private String writeUp;

}
