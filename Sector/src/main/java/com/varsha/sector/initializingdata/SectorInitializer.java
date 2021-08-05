package com.varsha.sector.initializingdata;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.varsha.sector.dao.SectorDao;
import com.varsha.sector.entities.Company;
import com.varsha.sector.entities.Sector;

@Component
public class SectorInitializer implements CommandLineRunner {

	@Autowired
	private SectorDao sectorDao;

	@Override
	public void run(String... args) throws Exception {

		sectorDao.deleteAll();

		Sector sector1 = new Sector(UUID.randomUUID().toString(), "Finance",
				"Provides financial services to commercial and retail customers", new ArrayList<Company>());
		sectorDao.save(sector1);

		Sector sector2 = new Sector(UUID.randomUUID().toString(), "Healthcare Services",
				"A service that provides medical treatment and care to the public", new ArrayList<Company>());
		sectorDao.save(sector2);

		Sector sector3 = new Sector(UUID.randomUUID().toString(), "Pharmaceuticals",
				"Discovers, develops, produces, and markets pharmaceutical drugs for use as medications to be administered",
				new ArrayList<Company>());
		sectorDao.save(sector3);
	}
}
