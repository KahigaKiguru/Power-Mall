package com.rohithreddy.PowerMallApplication.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "consumers")
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "consumer_id")
	private int id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "consumers_roles",
			joinColumns = @JoinColumn(name = "consumer_id", referencedColumnName = "consumer_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	@Column(name = "producer_name")
	private String name;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "grid_id"))
	private Grid grid;
	
	@Column(name = "energy_consumed")
	private double energyConsumed;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "producer_id"))
	private Producer producer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public double getEnergyConsumed() {
		return energyConsumed;
	}

	public void setEnergyConsumed(double energyConsumed) {
		this.energyConsumed = energyConsumed;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	
}
