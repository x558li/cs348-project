package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.ManufactuterDao;
import org.Info.Vehicle.model.Manufactuter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("manufactuterService")
public class ManufactuterService {

	@Autowired
	ManufactuterDao manufactuterDao;

	@Transactional
	public List<Manufactuter> getAllManufactuter() {
		return manufactuterDao.getAllManufactuter();
	}

	@Transactional
	public Manufactuter getManufactuter(int id) {
		return manufactuterDao.getManufactuter(id);
	}

	@Transactional
	public Manufactuter addManufactuter(Manufactuter manufactuter) {
		manufactuterDao.addManufactuter(manufactuter);
		return manufactuter;
	}

	@Transactional
	public Manufactuter updateManufactuter(Manufactuter manufactuter) {
		manufactuterDao.updateManufactuter(manufactuter);
		return manufactuter;
	}

	@Transactional
	public void deleteManufactuter(int id) {
		manufactuterDao.deleteManufactuter(id);
	}
}
