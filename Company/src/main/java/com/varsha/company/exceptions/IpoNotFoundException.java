package com.varsha.company.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class IpoNotFoundException extends RuntimeException {
	public IpoNotFoundException(String message) {
		super(message);
	}
}
