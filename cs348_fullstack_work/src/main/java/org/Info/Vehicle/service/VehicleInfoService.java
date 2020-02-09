package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.VehicleInfoDao;
import org.Info.Vehicle.model.VehicleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("VehicleInfoService")
public class VehicleInfoService {

	@Autowired
	VehicleInfoDao vehicleInfoDao;

	@Transactional
	public List<VehicleInfo> getAllVehicleInfo() {
		return vehicleInfoDao.getAllVehicleInfo();
	}

	@Transactional
	public VehicleInfo getVehicleInfo(int id) {
		return vehicleInfoDao.getVehicleInfo(id);
	}

	@Transactional
	public VehicleInfo addVehicleInfo(VehicleInfo vehicleInfo) {
		vehicleInfoDao.addVehicleInfo(vehicleInfo);
		return vehicleInfo;
	}

	@Transactional
	public VehicleInfo updateVehicleInfo(VehicleInfo vehicleInfo) {
		vehicleInfoDao.updateVehicleInfo(vehicleInfo);
		return vehicleInfo;
	}

	@Transactional
	public void deleteVehicleInfo(int id) {
		vehicleInfoDao.deleteVehicleInfo(id);
	}
}
