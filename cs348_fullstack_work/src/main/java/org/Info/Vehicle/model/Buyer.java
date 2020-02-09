
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Buyer table in database
 */
@Entity
@Table(name="Buyer")
public class Buyer{

	@Id
	@Column(name="bid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int bid;

	@Column(name="uid")
	int uid; 

	public Buyer() {
		super();
	}

	public Buyer(int bid, int uid) {
		super();
		this.bid=bid;
		this.uid=uid;
	}
	
	public int getUid() {
		return this.uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
}
