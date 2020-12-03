package com.rohithreddy.PowerMallApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

//	index page
	public String showIndex() {
		return "index";
	}
}
