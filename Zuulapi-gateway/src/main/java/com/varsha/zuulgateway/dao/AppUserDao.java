package com.varsha.zuulgateway.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.varsha.zuulgateway.appuser.AppUser;

@Repository
public interface AppUserDao extends MongoRepository<AppUser, String> {
	public Optional<AppUser> findByEmail(String email);
}
