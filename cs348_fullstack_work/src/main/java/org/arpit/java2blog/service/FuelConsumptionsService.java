package org.arpit.java2blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.arpit.java2blog.dao.FuelConsumptionsDao;
import org.arpit.java2blog.model.FuelConsumptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("fuelConsumptionsService")
public class FuelConsumptionsService {

	@Autowired
	FuelConsumptionsDao fuelConsumptionsDao;

	@Transactional
	public List<FuelConsumptions> getAllFuelConsumptions() {
		return fuelConsumptionsDao.getAllFuelConsumptions();
	}

	@Transactional
	public FuelConsumptions getFuelConsumption(int id) {
		return fuelConsumptionsDao.getFuelConsumption(id);
	}

	@Transactional
	public FuelConsumptions addFuelConsumption(FuelConsumptions fuelConsumptions) {
		fuelConsumptionsDao.addFuelConsumption(fuelConsumptions);
		return fuelConsumptions;
	}

	@Transactional
	public FuelConsumptions updateFuelConsumption(FuelConsumptions fuelConsumptions) {
		fuelConsumptionsDao.updateFuelConsumption(fuelConsumptions);
		return fuelConsumptions;
	}

	@Transactional
	public void deleteFuelConsumption(int id) {
		fuelConsumptionsDao.deleteFuelConsumption(id);
	}
}
