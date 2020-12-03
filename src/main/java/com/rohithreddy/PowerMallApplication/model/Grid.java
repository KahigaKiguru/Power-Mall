package com.rohithreddy.PowerMallApplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grids")
public class Grid {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private List<Consumer> users;

}
