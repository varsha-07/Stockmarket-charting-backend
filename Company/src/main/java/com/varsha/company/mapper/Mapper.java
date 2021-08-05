package com.varsha.company.mapper;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.varsha.company.dto.CompanyDto;
import com.varsha.company.dto.IpoDto;
import com.varsha.company.entities.Company;
import com.varsha.company.entities.Ipo;

@Component
public class Mapper {
	public CompanyDto toCompanyDto(Company company) {
		ModelMapper mapper = new ModelMapper();
		CompanyDto companyDto = mapper.map(company, CompanyDto.class);
		return companyDto;
	}
	
	public Company toCompany(CompanyDto companyDto) {
		ModelMapper mapper = new ModelMapper();
		Company company = mapper.map(companyDto, Company.class);
		return company;
	}
	
	public List<CompanyDto> toCompanyDtoList(List<Company> companies){
		ModelMapper mapper = new ModelMapper();
		List<CompanyDto> companyDtoList = Arrays.asList(mapper.map(companies, CompanyDto[].class));
		return companyDtoList;
	}
	
	public Ipo toIpo(IpoDto ipoDto) {
		ModelMapper mapper = new ModelMapper();
		Ipo ipo = mapper.map(ipoDto, Ipo.class);
		return ipo;
	}
	
	public IpoDto toIpoDto(Ipo ipo) {
		ModelMapper mapper = new ModelMapper();
		IpoDto ipoDto = mapper.map(ipo, IpoDto.class);
		return ipoDto;
	}
	
	public List<IpoDto> toIpoDtoList(List<Ipo> ipos){
		ModelMapper mapper = new ModelMapper();
		List<IpoDto> ipoDtoList = Arrays.asList(mapper.map(ipos, IpoDto[].class));
		return ipoDtoList;
	}

	public List<Ipo> toIpoList(IpoDto ipoDto) {
		ModelMapper mapper = new ModelMapper();
		List<Ipo> ipoList = Arrays.asList(mapper.map(ipoDto, Ipo[].class));
		return ipoList;	
	}
	
}
