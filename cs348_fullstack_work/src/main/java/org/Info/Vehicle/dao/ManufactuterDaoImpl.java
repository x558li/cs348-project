package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Manufactuter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManufactuterDaoImpl implements ManufactuterDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Manufactuter> getAllManufactuter() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Manufactuter>  ManufactuterList = session.createQuery("from Manufactuter").list();
		return ManufactuterList;
	}

	public Manufactuter getManufactuter(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Manufactuter Manufactuter = (Manufactuter) session.get(Manufactuter.class, id);
		return Manufactuter;
	}

	public Manufactuter addManufactuter(Manufactuter Manufactuter) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Manufactuter);
		return Manufactuter;
	}

	public void updateManufactuter(Manufactuter Manufactuter) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Manufactuter);
	}

	public void deleteManufactuter(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Manufactuter p = (Manufactuter) session.load(Manufactuter.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
