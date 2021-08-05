package com.varsha.zuulgateway.appuser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.varsha.zuulgateway.dao.AppUserDao;
import com.varsha.zuulgateway.registration.token.ConfirmationToken;
import com.varsha.zuulgateway.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	@Autowired
	private AppUserDao appUserDao;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ConfirmationTokenService confirmationTokenService;

	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		AppUser user = appUserDao.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
		user.getappUserRole();
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(),
				user.getAuthorities());
	}

	public String signUpUser(AppUser appUser) {
		boolean userExists = appUserDao.findByEmail(appUser.getEmail()).isPresent();
		if (userExists) {
			throw new IllegalStateException("email already taken");
		}
		String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

		appUser.setPassword(encodedPassword);

		appUserDao.save(appUser);

		String token = UUID.randomUUID().toString();

		ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15), appUser);

		confirmationTokenService.saveConfirmationToken(confirmationToken);

		return token;
	}

	public boolean enableAppUser(String email) {
		AppUser appUser = appUserDao.findByEmail(email).get();
		appUser.setEnabled(true);
		appUser.setAppUserRole("USER");
		appUserDao.save(appUser);
		return true;
	}

}
