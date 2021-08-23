package com.varsha.stockprice.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.varsha.stockprice.entities.StockPrice;

public interface CompareService {
	
	public LinkedHashMap<String,Double> byDay(List<StockPrice> validStockPrices);
	public LinkedHashMap<String,Double> byWeek(List<StockPrice> validStockPrices);
	public LinkedHashMap<String,Double> byMonth(List<StockPrice> validStockPrices);
	public LinkedHashMap<String,Double> byYear(List<StockPrice> validStockPrices);

}
