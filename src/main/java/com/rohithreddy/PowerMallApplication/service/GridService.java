package com.rohithreddy.PowerMallApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohithreddy.PowerMallApplication.model.Grid;
import com.rohithreddy.PowerMallApplication.repository.GridRepository;

@Service
public class GridService {
	
	@Autowired
	private GridRepository gridRepository;
	
	public void createGrid(Grid grid) {
		gridRepository.save(grid);
	}
	
	public void deleteGrid(Grid grid) {
		gridRepository.save(grid);
	}
	
	public Iterable<Grid> getAllGrids(){
		return gridRepository.findAll();
	}
	
	public Grid getGridById(int grid_id) {
		return gridRepository.findById(grid_id).get();
	}

}
