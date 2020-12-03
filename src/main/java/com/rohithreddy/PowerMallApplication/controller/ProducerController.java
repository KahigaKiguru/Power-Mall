package com.rohithreddy.PowerMallApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rohithreddy.PowerMallApplication.model.Grid;
import com.rohithreddy.PowerMallApplication.model.Producer;
import com.rohithreddy.PowerMallApplication.service.GridService;
import com.rohithreddy.PowerMallApplication.service.ProducerService;

@Controller
@RequestMapping("/producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;

	@Autowired
	private GridService gridService;
	
	@ModelAttribute("producer")
	public Producer getProducerModel() {
		return new Producer();
	}
	
	@ModelAttribute("grid")
	public Grid getGridModel() {
		return new Grid();
	}
//	registration page
	@GetMapping("/registerPage")
	public String registerPage() {
		return "producer_login";
	}
//	register producer
	@PostMapping("/registerProducer")
	public String registerProducer(@ModelAttribute("producer") Producer producer) {
		producerService.createProducer(producer);
		return "redirect:/producer/registerPage?success";
	}
//	login page
	@GetMapping("/loginPage")
	public String loginPage() {
		return "producer_login";
	}
//	show producer page
	@GetMapping("/producerPage")
	public String showSellerPage() {
		return "producer_page";
	}
//	handle grids
	
//	-> show grids
//	-> join grid
//	-> leave grids
}
