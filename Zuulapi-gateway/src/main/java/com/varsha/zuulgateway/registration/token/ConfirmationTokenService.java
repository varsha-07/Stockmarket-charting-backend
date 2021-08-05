package com.varsha.zuulgateway.registration.token;

import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

	@Autowired
	private ConfirmationTokenDao confirmationTokenDao;

	public void saveConfirmationToken(ConfirmationToken token) {
		confirmationTokenDao.save(token);
	}

	public Optional<ConfirmationToken> getToken(String token) {
		return confirmationTokenDao.findByToken(token);
	}

	public boolean setConfirmedAt(String token) {
		ConfirmationToken confirmationToken = confirmationTokenDao.findByToken(token).get();
		confirmationToken.setConfirmedAt(LocalDateTime.now());
		confirmationTokenDao.save(confirmationToken);
		return true;
	}

}
