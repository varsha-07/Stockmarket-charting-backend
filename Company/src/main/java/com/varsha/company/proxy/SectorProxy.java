package com.varsha.company.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.varsha.company.dto.CompanyDto;

@FeignClient(name="sector-app")
public interface SectorProxy {
	
	@PostMapping("sector/addCompany/{sectorName}/{id}/companyDto")
	public void addCompany(@PathVariable String sectorName,@PathVariable String id,@RequestBody CompanyDto companyDto);
}
