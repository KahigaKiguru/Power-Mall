package com.enzitechnologies.PowerMallApplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enzitechnologies.PowerMallApplication.model.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer>{

	Seller findByEmailAddress(String email_address);
	
	List<Seller> findByGrid(String grid);
}
