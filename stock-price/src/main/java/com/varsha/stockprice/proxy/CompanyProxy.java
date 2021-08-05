package com.varsha.stockprice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "company-app")
public interface CompanyProxy {

	@PostMapping(value = "/company/getStockCode/{companyName}")
	public String getStockCode(@PathVariable String companyName);
}
