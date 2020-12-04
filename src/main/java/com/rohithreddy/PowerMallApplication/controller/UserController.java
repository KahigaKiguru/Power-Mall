package com.rohithreddy.PowerMallApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rohithreddy.PowerMallApplication.model.Seller;
import com.rohithreddy.PowerMallApplication.model.User;
import com.rohithreddy.PowerMallApplication.model.UserWrapper;
import com.rohithreddy.PowerMallApplication.service.SellerService;
import com.rohithreddy.PowerMallApplication.service.UserService;

@Controller
public class UserController {
	
	static List<String> grids = null;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	static {
		grids = new ArrayList<String>();
		grids.add("Philadelphia Grid");
		grids.add("Ohio Grid");
		grids.add("Delaware Grid");
		grids.add("Conneticut Grid");
		grids.add("Arkansas Grid");
		grids.add("Arizona Grid");
		grids.add("Florida Grid");
		
	}

	@Autowired
	private UserService userService;
	
	@Autowired
	private SellerService sellerService;
	
	@ModelAttribute("user")
	public User userModel() {
		return new User();
	}
	@ModelAttribute("seller")
	public Seller sellerModel() {
		return new Seller();
	}
//	index page
	@GetMapping("/")
	public String showLoginPage() {
		return "user_login";
	}
	@GetMapping("/login")
	public String showLogin() {
		return "user_login";
	}
	
//	register user page
	@GetMapping("/registerPage")
	public String showRegisterPage(Model model) {
		model.addAttribute("grid_list", grids);
		return "user_register";
	}
//	register user
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {
		userService.createUser(user);
		return "redirect:/registerPage?registration_successful";
	}
//	update page
	@GetMapping("/updatePage")
	public String showUpdatePage(@RequestParam("user_id") int user_id, Model model) {
		model.addAttribute("user", userService.getUserByID(user_id));
		model.addAttribute("grid_list", grids);
		return "user_update";
	}
//	update user
	@PostMapping("/update/{user_id}")
	public String updateUser(@PathVariable("user_id") int user_id, @ModelAttribute("user") User user_req) {
		User user = userService.getUserByID(user_id);
		
		if(sellerService.getSellerByEmail(user.getEmail()) != null) {
		Seller seller = sellerService.getSellerByEmail(user.getEmail());
		
		user.setName(user_req.getName());
		seller.setName(user_req.getName());
		user.setEmail(user_req.getEmail());
		seller.setEmailAddress(user_req.getEmail());
		user.setGrid(user_req.getGrid());
		seller.setGrid(user_req.getGrid());
		user.setSeller(seller);
		
		if(!user_req.getPassword().isBlank() || !user_req.getPassword().isEmpty()) {
			user.setPassword(passwordEncoder.encode(user_req.getPassword()));
		}
		userService.updateUser(user);
		sellerService.updateSeller(seller);
		} else {
			user.setName(user_req.getName());
			
			user.setEmail(user_req.getEmail());
			
			user.setGrid(user_req.getGrid());
			
			
			
			if(!user_req.getPassword().isBlank() || !user_req.getPassword().isEmpty()) {
				user.setPassword(passwordEncoder.encode(user_req.getPassword()));
			}
			userService.updateUser(user);
			
		}
		return "redirect:/index?update_successful";
	}
//	index
	@GetMapping("/index")
	public String showIndexPage(@AuthenticationPrincipal() UserWrapper userWrapper, Model model) {
		User user = userService.getUserByEmail(userWrapper.getUsername());
		
		model.addAttribute("user", user);
		
		return "index";
	}
//	buy power page
	@GetMapping("/buyPowerPage")
	public String showBuyPowerPage(@RequestParam("user_id") int user_id, Model model) {
		User user = userService.getUserByID(user_id);
		
		List<Seller> sellers = sellerService.getSellerByGrid(user.getGrid());
		
		model.addAttribute("user", user);
		model.addAttribute("sellers", sellers);
		
		return "buy_page";
	}
//	buy power confirmation
	@GetMapping("/buyPowerConfirmation")
	public String buyPowerConfirm( 
			@RequestParam("user_id")  int user_id,
			@RequestParam("seller_id")  int seller_id,
			Model model) {
		User user  = userService.getUserByID(user_id);
		Seller seller = sellerService.getSellerById(seller_id);
		model.addAttribute("seller", seller);
		model.addAttribute("user", user);
		
		return "buy_confirm";
	}
	
//	buy power
	@GetMapping("/buyPower/{user_id}/{seller_id}")
	public String buyPower(
			@PathVariable("user_id") int user_id,
			@PathVariable("seller_id") int seller_id,
			@RequestParam("quantity") double quantity, 
			Model model) {
		
		
		User user = userService.getUserByID(user_id);
		
		Seller seller = sellerService.getSellerById(seller_id);
		
		User seller_user = userService.getUserByEmail(seller.getEmailAddress());
		
		seller.setKiloWattHoursSold(seller.getKiloWattHoursSold() + quantity);
		
		seller_user.setUnitsSold(seller_user.getUnitsSold() + quantity);
		
		seller.setKiloWattHoursSold(seller.getKiloWattHoursSold() + quantity);
		seller.setKilowatthours(seller.getKilowatthours() - quantity);
		seller_user.setUnitsBought(seller_user.getUnitsBought() + quantity);
		user.setUnitsBought(user.getUnitsBought() + quantity);
		
		sellerService.updateSeller(seller);
		
		userService.updateUser(user);
		userService.updateUser(seller_user);
		model.addAttribute("seller", seller);
		
		return "redirect:/index?purchase_successful";
		
	}
	
//	sell power page
	@GetMapping("/sellPowerConfirmation")
	public String sellPowerConfirm(
			@RequestParam("user_id") int user_id,
			Model model) {
		User user = userService.getUserByID(user_id);
		Seller seller  = sellerService.getSellerByEmail(user.getEmail());
		model.addAttribute("user", user);
		model.addAttribute("seller", seller);	
		return "sale_confirm";
	}
	
//	sell power
	@GetMapping("/sellPower/{user_id}")
	public String sellPower(
			@RequestParam("quantity") int quantity, 
			@PathVariable("user_id") int user_id, 
			@RequestParam("price") double price, 
			Model model) {
		User user = userService.getUserByID(user_id);
		
		if(sellerService.getSellerByEmail(user.getEmail()) != null) {
		Seller mySeller =  sellerService.getSellerByEmail(user.getEmail());
		mySeller.setKilowatthours(mySeller.getKilowatthours() + quantity);
		mySeller.setPricePerKillowatt(price);
		
		sellerService.updateSeller(mySeller);
		
		model.addAttribute("seller", mySeller);
	} else {
		Seller mySeller = new Seller();
		mySeller.setName(user.getName());
		mySeller.setEmailAddress(user.getEmail());
		mySeller.setGrid(user.getGrid());
		mySeller.setKilowatthours(quantity);
		mySeller.setPricePerKillowatt(price);
		mySeller.setKiloWattHoursSold(0);
		
		sellerService.createSeller(mySeller);
		model.addAttribute("seller", mySeller);
	}
		
		return "redirect:/index?sale_successful";
	}
	
}
