package com.varsha.stockexchange.service;

import java.util.List;

import com.varsha.stockexchange.dto.CompanyDto;
import com.varsha.stockexchange.dto.StockExchangeDto;

public interface StockExchangeService {

	public List<StockExchangeDto> allStockExchanges();

	public StockExchangeDto findById(String id);

	public StockExchangeDto addStockExchange(StockExchangeDto stockExchangeDto);

	public StockExchangeDto editStockExchange(String id, StockExchangeDto stockExchangeDto);

	public StockExchangeDto addCompany(String stockExchangeName, String id, CompanyDto companyDto);

	public List<CompanyDto> getCompaniesById(String id);
}
