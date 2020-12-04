package com.rohithreddy.PowerMallApplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohithreddy.PowerMallApplication.model.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer>{

	Seller findByEmailAddress(String email_address);
	
	List<Seller> findByGrid(String grid);
}
