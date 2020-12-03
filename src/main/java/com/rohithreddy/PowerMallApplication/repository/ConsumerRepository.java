package com.rohithreddy.PowerMallApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohithreddy.PowerMallApplication.model.Consumer;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Integer>{

}
