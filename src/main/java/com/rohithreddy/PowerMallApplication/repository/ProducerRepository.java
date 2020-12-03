package com.rohithreddy.PowerMallApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohithreddy.PowerMallApplication.model.Producer;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer>{

	Producer findByEmailAddress(String email_address);
}
