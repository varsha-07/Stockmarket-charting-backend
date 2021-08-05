package com.varsha.company.entities;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	@Id
	private String id;
	
	private String userName;
	private String password;
	private String userType;
	private String email;
	private String mobileNumber;
	private boolean confirmed;
}
