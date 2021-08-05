package com.varsha.company.service;

import java.util.List;

import com.varsha.company.dto.CompanyDto;
import com.varsha.company.dto.IpoDto;


public interface CompanyService {
	
	public CompanyDto addCompany(CompanyDto companyDto);
	public List<CompanyDto> allCompanies();
	public CompanyDto editCompany(String id,CompanyDto companyDto);
	public CompanyDto deactivateCompany(String id);
	public CompanyDto getCompanyDetails(String id);
	public List<CompanyDto> getMatchingCompanies(String match);
	public List<IpoDto> getCompanyIpoDetails(String id);
	public IpoDto addIpo(String id,IpoDto ipoDto);
	public IpoDto deleteIpo(String id);
	public IpoDto editIpo(String id,IpoDto ipoDto);
	public String getStockCode(String companyName);
}
