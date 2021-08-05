package com.varsha.zuulgateway.registration;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.varsha.zuulgateway.appuser.AppUser;
import com.varsha.zuulgateway.appuser.AppUserService;
import com.varsha.zuulgateway.dao.AppUserDao;
import com.varsha.zuulgateway.registration.mail.EmailSender;
import com.varsha.zuulgateway.registration.token.ConfirmationToken;
import com.varsha.zuulgateway.registration.token.ConfirmationTokenService;

@Service
public class RegistrationService {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private AppUserDao appUserDao;

	@Autowired
	private EmailValidation emailValidation;

	@Autowired
	private ConfirmationTokenService confirmationTokenService;

	@Autowired
	private EmailSender emailSender;

	private static final String ROLE = "GUEST";

	@PostMapping
	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidation.test(request.getEmail());

		if (!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}

		String token = appUserService.signUpUser(new AppUser(request.getUsername(), request.getEmail(),
				request.getPassword(), request.getMobileNumber(), ROLE));
		String link = "Click this Link to activate your account: http://localhost:8765/stockApp/app/signup/confirm?token="
				+ token;
		emailSender.send(request.getEmail(), link);

		return token;
	}

	public String confirmToken(String token) {
		ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
				.orElseThrow(() -> new IllegalStateException("token not found"));

		if (confirmationToken.getConfirmedAt() != null) {
			throw new IllegalStateException("email already confirmed");
		}

		LocalDateTime expiredAt = confirmationToken.getExpiresAt();

		if (expiredAt.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("token expired");
		}

		confirmationTokenService.setConfirmedAt(token);
		appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());
		return "confirmed";
	}

	public RegistrationRequest updateDetails(RegistrationRequest request) {
		if (!appUserDao.findByEmail(request.getEmail()).isPresent()) {
			return null;
		}
		AppUser reg = appUserDao.findByEmail(request.getEmail()).get();
		reg.setUsername(request.getUsername());
		reg.setEmail(request.getEmail());
		reg.setPassword(request.getPassword());
		reg.setMobileNumber(request.getMobileNumber());
		appUserDao.save(reg);
		return request;
	}
}
