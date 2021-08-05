package com.varsha.company.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.varsha.company.entities.Company;

@Repository
public interface CompanyDao extends MongoRepository<Company,String> {
	public List<Company> findAllByCompanyNameStartingWithIgnoreCase(String match);
	public boolean existsByCompanyName(String companyName);
	public Company findByCompanyNameIgnoreCase(String companyName);
	public List<Company> findAllByActiveIsTrue();
//	public Company findById(String name);

}
