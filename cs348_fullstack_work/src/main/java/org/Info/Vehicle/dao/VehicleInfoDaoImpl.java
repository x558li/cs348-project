package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.VehicleInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleInfoDaoImpl implements VehicleInfoDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<VehicleInfo> getAllVehicleInfo() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VehicleInfo>  vehicleInfoList = session.createQuery("from VehicleInfo").list();
		return vehicleInfoList;
	}

	public VehicleInfo getVehicleInfo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleInfo vehicleInfo = (VehicleInfo) session.get(VehicleInfo.class, id);
		return vehicleInfo;
	}

	public VehicleInfo addVehicleInfo(VehicleInfo vehicleInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(vehicleInfo);
		return vehicleInfo;
	}

	public void updateVehicleInfo(VehicleInfo vehicleInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vehicleInfo);
	}

	public void deleteVehicleInfo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleInfo p = (VehicleInfo) session.load(VehicleInfo.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
