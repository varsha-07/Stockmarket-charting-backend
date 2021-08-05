package com.varsha.zuulgateway.registration.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void send(String to, String link) {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("m.varshao2@gmail.com");
		mail.setTo(to);
		mail.setSubject("Confirmation");
		mail.setText(link);

		javaMailSender.send(mail);
	}

}
