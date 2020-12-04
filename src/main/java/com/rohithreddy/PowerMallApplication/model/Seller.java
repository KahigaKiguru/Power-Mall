package com.rohithreddy.PowerMallApplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sellers")
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
	
	@Column(name = "price_per_killowatt")
	private double pricePerKillowatt;
	
	@Column(name = "grid_name")
	private String grid;
	
	@OneToOne()
	@JoinColumn(name = "user_id")
	private User user;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public double getPricePerKillowatt() {
		return pricePerKillowatt;
	}

	public void setPricePerKillowatt(double pricePerKillowatt) {
		this.pricePerKillowatt = pricePerKillowatt;
	}	
	
	
	
}
