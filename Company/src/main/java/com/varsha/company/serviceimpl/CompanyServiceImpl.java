package com.varsha.company.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsha.company.dao.CompanyDao;
import com.varsha.company.dao.IpoDao;
import com.varsha.company.dto.CompanyDto;
import com.varsha.company.dto.IpoDto;
import com.varsha.company.entities.Company;
import com.varsha.company.entities.Ipo;
import com.varsha.company.mapper.Mapper;
import com.varsha.company.proxy.SectorProxy;
import com.varsha.company.proxy.StockExchangeProxy;
import com.varsha.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private IpoDao ipoDao;
	
	@Autowired
	private SectorProxy sectorProxy;
	
	@Autowired
	private StockExchangeProxy stockExchangeProxy;
	
	@Override
    public List<CompanyDto> allCompanies(){
		List<Company> details= companyDao.findAllByActiveIsTrue();
		return mapper.toCompanyDtoList(details);
	}
	@Override
	public CompanyDto addCompany(CompanyDto companyDto) {
		Company addDetails=mapper.toCompany(companyDto);
		addDetails.setActive(true);
		addDetails=companyDao.save(addDetails);
		String id = addDetails.getId();
		String[] stockExchanges = addDetails.getListOfStockExchanges().split(",");
		for (String stockExchange: stockExchanges) {
			stockExchangeProxy.addCompany(stockExchange, id, companyDto);
		}
		sectorProxy.addCompany(addDetails.getSector(),id,companyDto);
		return mapper.toCompanyDto(addDetails);
		
	}
	
	@Override
	public CompanyDto editCompany(String id,CompanyDto companyDto) {
		Company editDetails=mapper.toCompany(companyDto);
		editDetails.setId(id);
		editDetails=companyDao.save(editDetails);
		return mapper.toCompanyDto(editDetails);
	}
	
	@Override
	public CompanyDto deactivateCompany(String id) {
		if(!companyDao.existsById(id)) {
			return null;
		}
		Company deactivate = companyDao.findById(id).get();
		deactivate.setActive(false);
		deactivate = companyDao.save(deactivate);
		return mapper.toCompanyDto(deactivate);
	}
	
	
	@Override
	public CompanyDto getCompanyDetails(String companyName) {
		Company company = companyDao.findByCompanyNameIgnoreCase(companyName);
		if (company == null) {
			return null;
		}
		return mapper.toCompanyDto(company);
	}
	
	@Override
	public List<CompanyDto> getMatchingCompanies(String match){
		List<Company> companyMatch = companyDao.findAllByCompanyNameStartingWithIgnoreCase(match);
		return mapper.toCompanyDtoList(companyMatch);
	}
	
	@Override
	public List<IpoDto> getCompanyIpoDetails(String companyName){
		List<Ipo> ipoDetails = ipoDao.findAllByCompanyNameIgnoreCaseOrderByOpenDateTime(companyName);
		return mapper.toIpoDtoList(ipoDetails);
	}
	@Override
	public IpoDto addIpo(String companyName,IpoDto ipoDto) {
		Company companyData = companyDao.findByCompanyNameIgnoreCase(companyName);
		if(companyData == null)
			return null;
		Ipo ipoData = mapper.toIpo(ipoDto);
		ipoData = ipoDao.save(ipoData);
		companyData.getIpos().add(ipoData);
		companyData = companyDao.save(companyData);
		return mapper.toIpoDto(ipoData);
	}
	
	@Override
	public IpoDto deleteIpo(String id) {
		if (!ipoDao.existsById(id))
			return null;
		Ipo ipoData = ipoDao.findById(id).get();
		String companyName = ipoData.getCompanyName();
		Company companyData = companyDao.findByCompanyNameIgnoreCase(companyName);
		companyData.getIpos().remove(ipoData);
		companyDao.save(companyData);
		ipoDao.deleteById(id);
		return mapper.toIpoDto(ipoData);
	}
	
	@Override
	public IpoDto editIpo(String id,IpoDto ipoDto) {
		if (!ipoDao.existsById(id))
			return null;
		Ipo updatedIpo = ipoDao.save(mapper.toIpo(ipoDto));
		return mapper.toIpoDto(updatedIpo);
	}
	
	@Override
	public String getStockCode(String companyName) {
		Company company = companyDao.findByCompanyNameIgnoreCase(companyName);
		return company.getStockCode();
	}

}
