package com.varsha.stockprice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varsha.stockprice.entities.CompareData;

public interface CompareDao extends MongoRepository<CompareData,String>{

}
