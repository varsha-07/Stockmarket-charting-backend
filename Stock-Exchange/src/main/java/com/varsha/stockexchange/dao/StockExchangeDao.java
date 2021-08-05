package com.varsha.stockexchange.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.varsha.stockexchange.entities.StockExchange;

@Repository
public interface StockExchangeDao extends MongoRepository<StockExchange, String> {

	public StockExchange findByStockExchange(String stockExchange);
}
