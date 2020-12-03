package com.rohithreddy.PowerMallApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohithreddy.PowerMallApplication.model.Grid;

@Repository
public interface GridRepository extends CrudRepository<Grid, Integer>{

}
