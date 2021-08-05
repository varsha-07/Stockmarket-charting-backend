package com.varsha.zuulgateway.initializingdata;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.varsha.zuulgateway.appuser.AppUser;
import com.varsha.zuulgateway.dao.AppUserDao;

@Component
public class Admin implements CommandLineRunner {

	@Autowired
	private AppUserDao appUserDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {

		if (!appUserDao.findByEmail("varsha02@protonmail.com").isPresent()) {
			AppUser admin = new AppUser();

			String encodedPassword = bCryptPasswordEncoder.encode("password");
			admin.setId(UUID.randomUUID().toString());
			admin.setUsername("admin1");
			admin.setEmail("varsha02@protonmail.com");
			admin.setPassword(encodedPassword);
			admin.setMobileNumber("9234567891");
			admin.setAppUserRole("ADMIN");
			admin.setLocked(false);
			admin.setEnabled(true);

			appUserDao.save(admin);
		}
	}

}
