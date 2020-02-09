
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Manufactuter table in database
 */
@Entity
@Table(name="Manufactuter")
public class Manufactuter{

	@Id
	@Column(name="manu_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int manu_id;

	@Column(name="uid")
	int uid; 

	public Manufactuter() {
		super();
	}

	public Manufactuter(int manu_id, int uid) {
		super();
		this.manu_id=manu_id;
		this.uid=uid;
	}
	
	public int getUid() {
		return this.uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAid() {
		return manu_id;
	}
	public void setAid(int manu_id) {
		this.manu_id = manu_id;
	}
	
}
