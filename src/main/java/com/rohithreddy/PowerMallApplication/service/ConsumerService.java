package com.rohithreddy.PowerMallApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rohithreddy.PowerMallApplication.model.Consumer;
import com.rohithreddy.PowerMallApplication.model.ConsumerWrapper;
import com.rohithreddy.PowerMallApplication.repository.ConsumerRepository;

@Service
public class ConsumerService implements UserDetailsService {

	@Autowired
	private ConsumerRepository consumerRepository;


	public void createConsumer(Consumer consumer) {
		consumerRepository.save(consumer);
	}
	
	public void updateConsumer(Consumer consumer) {
		consumerRepository.save(consumer);
	}
	
	public Consumer getConsumerByID(int consumer_id) {
		return consumerRepository.findById(consumer_id).get();
	}
	
	public Iterable<Consumer> getAllConsumers(){
		return consumerRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Consumer consumer = consumerRepository.findByEmailAddress(username);
		
		if(consumer != null) {
			return new ConsumerWrapper(consumer);
		}
		throw new UsernameNotFoundException("user not found");
	}

}
