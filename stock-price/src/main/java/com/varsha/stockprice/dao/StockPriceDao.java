package com.varsha.stockprice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varsha.stockprice.entities.StockPrice;

public interface StockPriceDao extends MongoRepository<StockPrice, String> {

	public List<StockPrice> findAllByCompanyCodeAndStockExchangeIgnoreCase(String companyCode, String stockExchange);
}
