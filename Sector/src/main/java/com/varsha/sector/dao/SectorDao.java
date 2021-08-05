package com.varsha.sector.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.varsha.sector.entities.Sector;

@Repository
public interface SectorDao extends MongoRepository<Sector, String> {

	public Sector findBySectorNameIgnoreCase(String sectorName);
}
