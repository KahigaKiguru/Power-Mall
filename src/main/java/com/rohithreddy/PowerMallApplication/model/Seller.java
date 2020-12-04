package com.rohithreddy.PowerMallApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "seller", uniqueConstraints = @UniqueConstraint(columnNames = "email_address"))
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seller_id")
	private int id;
	
	@Column(name = "seller_name")
	private String name;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "kilowatt_hours")
	private double kilowatthours;
	
	@Column(name = "kilowatts_sold")
	private double kiloWattHoursSold;
	
	@Column(name = "grid_name")
	private String grid;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public double getKiloWattHoursSold() {
		return kiloWattHoursSold;
	}

	public void setKiloWattHoursSold(double kiloWattHoursSold) {
		this.kiloWattHoursSold = kiloWattHoursSold;
	}

	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public double getKilowatthours() {
		return kilowatthours;
	}

	public void setKilowatthours(double kilowatthours) {
		this.kilowatthours = kilowatthours;
	}
	
	
}
