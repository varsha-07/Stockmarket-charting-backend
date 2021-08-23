package com.varsha.stockprice.service;

import java.text.ParseException;
import java.util.List;

import com.varsha.stockprice.dto.CompareDto;
import com.varsha.stockprice.dto.CompareResponseDto;
import com.varsha.stockprice.dto.StockPriceDto;

public interface StockPriceService {

	public List<StockPriceDto> findAll();

	public StockPriceDto findById(String id);

	public StockPriceDto update(StockPriceDto stockPriceDto);

	public String deleteById(String id);

	public List<StockPriceDto> save(List<StockPriceDto> stockPriceDtos);

	public CompareResponseDto companyComparison(CompareDto compareDto) throws ParseException;

	public CompareResponseDto sectorComparison(CompareDto compareDto) throws ParseException;

}
