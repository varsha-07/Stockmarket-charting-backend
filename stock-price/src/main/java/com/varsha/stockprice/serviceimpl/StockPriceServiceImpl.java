package com.varsha.stockprice.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsha.stockprice.dao.StockPriceDao;
import com.varsha.stockprice.dto.CompanyDto;
import com.varsha.stockprice.dto.CompareDto;
import com.varsha.stockprice.dto.StockPriceDto;
import com.varsha.stockprice.entities.StockPrice;
import com.varsha.stockprice.mapper.Mapper;
import com.varsha.stockprice.proxy.CompanyProxy;
import com.varsha.stockprice.proxy.SectorProxy;
import com.varsha.stockprice.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	private StockPriceDao stockPriceDao;

	@Autowired
	private Mapper mapper;

	@Autowired
	private CompanyProxy companyProxy;

	@Autowired
	private SectorProxy sectorProxy;

	@Override
	public List<StockPriceDto> findAll() {
		List<StockPrice> priceDetails = stockPriceDao.findAll();
		return mapper.toStockPriceDtoList(priceDetails);
	}

	@Override
	public StockPriceDto findById(String id) {
		StockPrice priceDetail = stockPriceDao.findById(id).get();
		return mapper.toStockPriceDto(priceDetail);
	}

	@Override
	public StockPriceDto update(StockPriceDto stockPriceDto) {
		if (!stockPriceDao.existsById(stockPriceDto.getId()))
			return null;
		StockPrice updateDetails = mapper.toStockPrice(stockPriceDto);
		updateDetails = stockPriceDao.save(updateDetails);
		return mapper.toStockPriceDto(updateDetails);
	}

	@Override
	public String deleteById(String id) {
		if (!stockPriceDao.existsById(id))
			return "Does not exists";
		stockPriceDao.deleteById(id);
		return "Deleted!";
	}

	@Override
	public List<StockPriceDto> save(List<StockPriceDto> stockPriceDtos) {
		List<StockPrice> stockDetails = mapper.toStockPriceList(stockPriceDtos);
		stockDetails = stockPriceDao.saveAll(stockDetails);
		return mapper.toStockPriceDtoList(stockDetails);
	}

	@Override
	public List<StockPriceDto> companyComparison(CompareDto compareDto) throws ParseException {
		Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(compareDto.getFromDate());
		Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(compareDto.getToDate());

		String companyCode = companyProxy.getStockCode(compareDto.getName());
		List<StockPrice> stockPrices = stockPriceDao.findAllByCompanyCodeAndStockExchangeIgnoreCase(companyCode,
				compareDto.getStockExchange());

		List<StockPrice> validStockPrices = stockPrices.stream().filter(stockPrice -> {
			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(stockPrice.getDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date.after(fromDate) && date.before(toDate);
		}).collect(Collectors.toList());
		return mapper.toStockPriceDtoList(validStockPrices);
	}

	@Override
	public List<StockPriceDto> sectorComparison(CompareDto compareDto) throws ParseException {

		Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(compareDto.getFromDate());
		Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(compareDto.getToDate());
		List<CompanyDto> companies = sectorProxy.getCompaniesBySector(compareDto.getName());
		List<StockPrice> allValidStockPrices = new ArrayList<>();
		for (CompanyDto companyDto : companies) {
			List<StockPrice> stockPrices = stockPriceDao.findAllByCompanyCodeAndStockExchangeIgnoreCase(
					companyDto.getStockCode(), compareDto.getStockExchange());

			List<StockPrice> validStockPrices = stockPrices.stream().filter(stockPrice -> {
				Date date = null;
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(stockPrice.getDate());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return date.after(fromDate) && date.before(toDate);
			}).collect(Collectors.toList());
			allValidStockPrices.addAll(validStockPrices);
		}
		return mapper.toStockPriceDtoList(allValidStockPrices);
	}

}
