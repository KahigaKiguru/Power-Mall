package com.rohithreddy.PowerMallApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohithreddy.PowerMallApplication.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByEmail(String email);
	
}
