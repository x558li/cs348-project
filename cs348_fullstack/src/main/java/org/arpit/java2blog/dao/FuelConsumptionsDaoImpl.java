package org.arpit.java2blog.dao;

import java.util.List;
import org.arpit.java2blog.model.FuelConsumptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FuelConsumptionsDaoImpl implements FuelConsumptionsDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<FuelConsumptions> getAllFuelConsumptions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<FuelConsumptions>  fuelConsumptionsList = session.createQuery("from FUELCONSUMPTION2019").list();
		return fuelConsumptionsList;
	}

	public FuelConsumptions getFuelConsumption(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		FuelConsumptions fuelConsumptions = (FuelConsumptions) session.get(FuelConsumptions.class, id);
		return fuelConsumptions;
	}

	public FuelConsumptions addFuelConsumption(FuelConsumptions fuelConsumption) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(fuelConsumption);
		return fuelConsumption;
	}

	public void updateFuelConsumption(FuelConsumptions fuelConsumptions) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(fuelConsumptions);
	}

	public void deleteFuelConsumption(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		FuelConsumptions p = (FuelConsumptions) session.load(FuelConsumptions.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
