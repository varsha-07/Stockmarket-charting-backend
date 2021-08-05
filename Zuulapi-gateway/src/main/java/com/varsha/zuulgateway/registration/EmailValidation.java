package com.varsha.zuulgateway.registration;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailValidation implements Predicate<String> {

	private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	@Override
	public boolean test(String email) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
