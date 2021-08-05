package com.varsha.company.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.varsha.company.entities.Ipo;

@Repository
public interface IpoDao extends MongoRepository<Ipo,String> {
	public List<Ipo> findAllByCompanyName(String companyName);
	public List<Ipo> findAllByCompanyNameIgnoreCaseOrderByOpenDateTime(String companyName);
}
