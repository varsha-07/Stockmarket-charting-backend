package com.varsha.zuulgateway.registration;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/stockApp/app")
public class RegistrationController {

	private RegistrationService registrationService;

	@GetMapping(path = "/homeee")
	public String home() {
		return "HOME";
	}

	@PostMapping(path = "/signup")
	public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<Object>(request, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(registrationService.register(request));
	}

	@GetMapping(path = "/signup/confirm")
	public String confirm(@RequestParam("token") String token) {
		return registrationService.confirmToken(token);
	}

	@PutMapping(path = "/updateDetails")
	public ResponseEntity<?> updateDetails(@RequestBody @Valid RegistrationRequest request, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<Object>(request, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(registrationService.updateDetails(request));

	}

}
