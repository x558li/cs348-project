package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.FuelConsumptionsDao;
import org.Info.Vehicle.model.FuelConsumptions;
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
