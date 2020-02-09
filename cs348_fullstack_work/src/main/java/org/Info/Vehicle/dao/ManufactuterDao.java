package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Manufactuter;

public interface ManufactuterDao {
		public List<Manufactuter> getAllManufactuter();

		public Manufactuter getManufactuter(int id) ;

		public Manufactuter addManufactuter(Manufactuter manufactuter);

		public void updateManufactuter(Manufactuter manufactuter) ;

		public void deleteManufactuter(int uid) ;
}
