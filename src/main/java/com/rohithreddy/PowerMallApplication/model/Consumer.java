package com.rohithreddy.PowerMallApplication.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consumers")
public class Consumer {
	
	private int id;
	
	private Collection<Role> roles;
	
	private String address;
	
	private Grid grid;
	
	

}
