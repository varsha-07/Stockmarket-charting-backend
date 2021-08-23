package com.varsha.stockprice.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsha.stockprice.dao.CompareDao;
import com.varsha.stockprice.entities.StockPrice;
import com.varsha.stockprice.service.CompareService;

@Service
public class CompareServiceImpl implements CompareService{
	
	@Autowired
	private CompareDao compareDao;
	
	@Override
	public LinkedHashMap<String,Double> byDay(List<StockPrice> validStockPrices) {
		double sum = 0;
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		LinkedHashMap<String,Double> chartData = new LinkedHashMap<String,Double>();
		validStockPrices.sort(Comparator.comparing(StockPrice::getDate));
		Date date = validStockPrices.get(0).getDate();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		for (StockPrice stockPrice : validStockPrices) {

			cal2.setTime(stockPrice.getDate());
			boolean sameDay = cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
			if (sameDay) {
				sum = sum + stockPrice.getCurrentPrice();
			}
			else {
				String formatted = format1.format(cal1.getTime());
				chartData.put(formatted, sum);
				sum = 0;
				cal1.setTime(stockPrice.getDate());
				sum = sum + stockPrice.getCurrentPrice();
			}
		}
		String formatedDate = format1.format(cal1.getTime());
		chartData.put(formatedDate, sum);
		return chartData;
	}
	
	@Override
	public LinkedHashMap<String,Double> byWeek(List<StockPrice> validStockPrices) {
		double sum = 0;
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		LinkedHashMap<String,Double> chartData = new LinkedHashMap<String,Double>();
		validStockPrices.sort(Comparator.comparing(StockPrice::getDate));
		Date date = validStockPrices.get(0).getDate();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		for (StockPrice stockPrice : validStockPrices) {
			cal2.setTime(stockPrice.getDate());
			boolean sameMonth = cal1.get(Calendar.WEEK_OF_MONTH) == cal2.get(Calendar.WEEK_OF_MONTH) &&
            cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
			if (sameMonth) {
				sum = sum + stockPrice.getCurrentPrice();
			}
			else {
				String formatedDate = format1.format(cal1.getTime());
				chartData.put(formatedDate, sum);
				sum = 0;
				cal1.setTime(stockPrice.getDate());
				sum = sum + stockPrice.getCurrentPrice();
			}
		}
		String formatedDate = format1.format(cal1.getTime());
		chartData.put(formatedDate, sum);
		return chartData;
	}
	
	@Override
	public LinkedHashMap<String,Double> byMonth(List<StockPrice> validStockPrices) {
		double sum = 0;
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		LinkedHashMap<String,Double> chartData = new LinkedHashMap<String,Double>();
		validStockPrices.sort(Comparator.comparing(StockPrice::getDate));
		Date date = validStockPrices.get(0).getDate();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		for (StockPrice stockPrice : validStockPrices) {
			cal2.setTime(stockPrice.getDate());
			boolean sameMonth = cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
            cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
			if (sameMonth) {
				sum = sum + stockPrice.getCurrentPrice();
			}
			else {
				String formatedDate = format1.format(cal1.getTime());
				chartData.put(formatedDate,sum);
				sum = 0;
				cal1.setTime(stockPrice.getDate());
				sum = sum + stockPrice.getCurrentPrice();
			}
		}
		String formatedDate = format1.format(cal1.getTime());
		chartData.put(formatedDate, sum);
		return chartData;
	}

	@Override
	public LinkedHashMap<String,Double> byYear(List<StockPrice> validStockPrices) {
		double sum = 0;
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		LinkedHashMap<String,Double> chartData = new LinkedHashMap<String,Double>();
		validStockPrices.sort(Comparator.comparing(StockPrice::getDate));
		Date date = validStockPrices.get(0).getDate();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		for (StockPrice stockPrice : validStockPrices) {
			cal2.setTime(stockPrice.getDate());
			boolean sameMonth = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
			if (sameMonth) {
				sum = sum + stockPrice.getCurrentPrice();
			}
			else {
				String formatedDate = format1.format(cal1.getTime());
				chartData.put(formatedDate,sum);				
				sum = 0;
				cal1.setTime(stockPrice.getDate());
				sum = sum + stockPrice.getCurrentPrice();
			}
		}
		String formatedDate = format1.format(cal1.getTime());
		chartData.put(formatedDate, sum);
		
		return chartData;
	}
}

