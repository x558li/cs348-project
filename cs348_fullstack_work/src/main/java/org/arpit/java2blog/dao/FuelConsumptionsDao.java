package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.FuelConsumptions;

public interface FuelConsumptionsDao {
	public List<FuelConsumptions> getAllFuelConsumptions() ;

	public FuelConsumptions getFuelConsumption(int id) ;

	public FuelConsumptions addFuelConsumption(FuelConsumptions fuelConsumption);

	public void updateFuelConsumption(FuelConsumptions fuelConsumptions) ;

	public void deleteFuelConsumption(int cid) ;
}
