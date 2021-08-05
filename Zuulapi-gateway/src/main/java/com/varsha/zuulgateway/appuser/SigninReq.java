package com.varsha.zuulgateway.appuser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninReq {
	private final String email;
	private final String password;
}
