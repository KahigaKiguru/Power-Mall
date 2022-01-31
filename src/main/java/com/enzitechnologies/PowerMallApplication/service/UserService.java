package com.enzitechnologies.PowerMallApplication.service;

import java.util.Arrays;

import com.enzitechnologies.PowerMallApplication.model.User;
import com.enzitechnologies.PowerMallApplication.model.UserWrapper;
import com.enzitechnologies.PowerMallApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.enzitechnologies.PowerMallApplication.model.Role;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		user.setName(user.getName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEmail(user.getEmail());
		user.setGrid(user.getGrid());
		user.setUnitsBought(0);
		user.setUnitsSold(0);
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public User getUserByID(int user_id) {
		return userRepository.findById(user_id).get();
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if(user != null) {
			return new UserWrapper(user);
		}
		throw new UsernameNotFoundException("user not found");
	}

}
