package com.enzitechnologies.PowerMallApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sellers")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

	
	
	
}
