package com.rohithreddy.PowerMallApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producer")
public class ProducerController {

//	registration page
	@GetMapping("/registerPage")
	public String registerPage() {
		return "producer_login";
	}
//	register producer
	@PostMapping("/registerProducer")
	public String registerProducer() {
		return "producer_login";
	}
//	login page
	@GetMapping("/loginPage")
	public String loginPage() {
		return "";
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
