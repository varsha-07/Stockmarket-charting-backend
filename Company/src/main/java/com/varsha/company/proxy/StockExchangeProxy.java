package com.varsha.company.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.varsha.company.dto.CompanyDto;

@FeignClient(name="stockexchange-app")
public interface StockExchangeProxy {
	
	@PostMapping(value="stockExchange/addCompany/{stockExchange}/{id}/companyDto")
	public void addCompany(@PathVariable String stockExchange, @PathVariable String id,@RequestBody CompanyDto companyDto);
}
