
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VehicleInfo")
public class VehicleInfo{

	@Id
	@Column(name="cid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int cid;

	@Column(name="Model_Year")
	String model_year; 

	@Column(name="Make")
	String make;

	@Column(name="Model")
	String model;
	
	@Column(name="Comb_Cons")
	String comb_cons;
	

	
	public VehicleInfo() {
		super();
	}
	public VehicleInfo(int cid,String model_year, String make, String model, String comb_cons) {
		super();
		this.cid=cid;
		this.model_year=model_year;
		this.make = make;
		this.model = model;
		this.comb_cons = comb_cons;
	}
	public int getCid() {
		return this.cid;
	}
	
	public String getModel_year() {
		return this.model_year;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getComb_cons() {
		return this.comb_cons;
	}
	
	public void setModel_year(String model_year) {
		this.model_year = model_year;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setComb_cons(String comb_cons) {
		this.comb_cons = comb_cons;
	}
	
}
