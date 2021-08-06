package com.varsha.company.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varsha.company.dto.CompanyDto;
import com.varsha.company.dto.IpoDto;
import com.varsha.company.exceptions.CompanyNotFoundException;
import com.varsha.company.exceptions.IpoNotFoundException;
import com.varsha.company.service.CompanyService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(value = "/allCompanies")
	public ResponseEntity<List<CompanyDto>> allDetails() {
		return ResponseEntity.ok(companyService.allCompanies());
	}
	
	@PostMapping(value = "/addCompany")
	public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
		return ResponseEntity.ok(companyService.addCompany(companyDto));
	}
	
	@PutMapping(value="/editCompany/{id}")
	public ResponseEntity<CompanyDto> editCompany(@PathVariable String id,@RequestBody CompanyDto companyDto){
		return ResponseEntity.ok(companyService.editCompany(id,companyDto));
	}
	
	@PostMapping(value="/deactivateCompany/{id}")
	public ResponseEntity<CompanyDto> deactivate(@PathVariable String id) {
		CompanyDto company = companyService.deactivateCompany(id);
		if (company == null) {
			throw new CompanyNotFoundException("Unable to find company with id: "+id);
		}
		return ResponseEntity.ok(company);
	}
	@PostMapping(value="/companyDetails/{companyName}")
	public ResponseEntity<CompanyDto> companyDetails(@PathVariable String companyName) {
		CompanyDto company = companyService.getCompanyDetails(companyName);
		if (company == null) {
			throw new CompanyNotFoundException("Unable to find company with name: "+companyName);
		}
		return ResponseEntity.ok(company);
	}
	
	@PostMapping(value = "/companies/{match}")
	public ResponseEntity<List<CompanyDto>> matchingCompanyDetails(@PathVariable String match) {
		return ResponseEntity.ok(companyService.getMatchingCompanies(match));
	}
	
	@PostMapping(value="/getIpo/{companyName}")
	public ResponseEntity<List<IpoDto>> getCompanyIpo(@PathVariable String companyName){
		return ResponseEntity.ok(companyService.getCompanyIpoDetails(companyName));
	}
	

	@PostMapping(value = "/addIpo/{companyName}")
	public ResponseEntity<IpoDto> addIpo(@PathVariable String companyName,@RequestBody IpoDto ipoDto) {
		IpoDto ipo = companyService.addIpo(companyName,ipoDto);
		if (ipo == null) {
			throw new CompanyNotFoundException("Unable to find company with name: "+companyName);
		}
		return ResponseEntity.ok(ipo);
	}
	
	@DeleteMapping(value="/deleteIpo/{id}")
	public ResponseEntity<IpoDto> deleteIpo(@PathVariable String id) {
		IpoDto ipo = companyService.deleteIpo(id);
		if (ipo == null)
			throw new IpoNotFoundException("Unable to find Ipo with id: "+id);
		return ResponseEntity.ok(ipo);
	}
	
	@PutMapping(value="/updateIpo/{id}")
	public ResponseEntity<IpoDto> editIpo(@PathVariable String id,@RequestBody IpoDto ipoDto) {
		IpoDto ipo = companyService.editIpo(id,ipoDto);
		if (ipo == null) {
			throw new IpoNotFoundException("Unable to find Ipo with id: "+ id);
		}
		return ResponseEntity.ok(ipo);
	}
	
	@PostMapping(value = "/getStockCode/{companyName}")
	public String getStockCode(@PathVariable String companyName) {
		return companyService.getStockCode(companyName);
	}
}
