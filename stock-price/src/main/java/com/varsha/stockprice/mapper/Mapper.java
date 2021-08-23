package com.varsha.stockprice.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.varsha.stockprice.dto.CompareResponseDto;
import com.varsha.stockprice.dto.StockPriceDto;
import com.varsha.stockprice.entities.StockPrice;

@Component
public class Mapper {

	public StockPrice toStockPrice(StockPriceDto stockPriceDto) {
		ModelMapper mapper = new ModelMapper();
		StockPrice stockPrice = mapper.map(stockPriceDto, StockPrice.class);
		return stockPrice;
	}

	public StockPriceDto toStockPriceDto(StockPrice stockPrice) {
		ModelMapper mapper = new ModelMapper();
		StockPriceDto stockPriceDto = mapper.map(stockPrice, StockPriceDto.class);
		return stockPriceDto;
	}

	public List<StockPriceDto> toStockPriceDtoList(List<StockPrice> stockprices) {
		ModelMapper mapper = new ModelMapper();
		List<StockPriceDto> stockPriceDtoList = Arrays.asList(mapper.map(stockprices, StockPriceDto[].class));
		return stockPriceDtoList;
	}

	public List<StockPrice> toStockPriceList(List<StockPriceDto> stockpriceDtos) {
		ModelMapper mapper = new ModelMapper();
		List<StockPrice> stockPriceList = Arrays.asList(mapper.map(stockpriceDtos, StockPrice[].class));
		return stockPriceList;
	}
	
	public List<CompareResponseDto> toCompareResponseDto(List<StockPrice> stockPrice) {
		ModelMapper mapper = new ModelMapper();
		List<CompareResponseDto> compareResponseDto = Arrays.asList(mapper.map(stockPrice, CompareResponseDto.class));
		return compareResponseDto;
	}

}
