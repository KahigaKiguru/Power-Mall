package com.rohithreddy.PowerMallApplication.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohithreddy.PowerMallApplication.model.Role;
import com.rohithreddy.PowerMallApplication.model.Seller;
import com.rohithreddy.PowerMallApplication.model.User;
import com.rohithreddy.PowerMallApplication.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private UserService userService;
	
	public Seller createSeller(User user) {
		Seller seller = new Seller();
		seller.setName(user.getName());
		seller.setEmailAddress(user.getEmail());
		seller.setGrid(user.getGrid());
		seller.setKiloWattHoursSold(0);
		seller.setKilowatthours(0);
		seller.setUser(user);
		seller.setPricePerKillowatt(0);
		user.setRoles(Arrays.asList(new Role("ROLE_SELLER")));
		
		userService.updateUser(user);
		
		return sellerRepository.save(seller);
	}
	
	public void updateSeller(Seller seller) {
		sellerRepository.save(seller);
	}
	
	public Iterable<Seller> getAllSellers(){
		return sellerRepository.findAll();
	}
	
	public Seller getSellerById(int seller_id) {
		return sellerRepository.findById(seller_id).get();
	}
	
	public List<Seller> getSellerByGrid(String grid){
		return sellerRepository.findByGrid(grid);
	}
	
	public Seller getSellerByEmail(String email) {
		
		return sellerRepository.findByEmailAddress(email);
	}
}
