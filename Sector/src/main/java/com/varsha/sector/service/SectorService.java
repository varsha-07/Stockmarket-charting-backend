package com.varsha.sector.service;

import java.util.List;

import com.varsha.sector.dto.CompanyDto;
import com.varsha.sector.dto.SectorDto;

public interface SectorService {

	public List<SectorDto> findAll();

	public SectorDto findById(String id);

	public SectorDto addSector(SectorDto sectorDto);

	public SectorDto deleteById(String id);

	public SectorDto addCompany(String sectorName, String id, CompanyDto companyDto);

	public List<CompanyDto> getCompaniesById(String id);

	public List<CompanyDto> getCompaniesBySector(String sectorName);
}
