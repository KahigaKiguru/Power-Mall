package com.rohithreddy.PowerMallApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rohithreddy.PowerMallApplication.model.Producer;
import com.rohithreddy.PowerMallApplication.model.ProducerWrapper;
import com.rohithreddy.PowerMallApplication.repository.ProducerRepository;

@Service
public class ProducerService  implements UserDetailsService{

	@Autowired
	private ProducerRepository producerRepository;
	
	public void createProducer(Producer producer) {
		producerRepository.save(producer);
	}
	
	public void updateProducer(Producer producer) {
		producerRepository.save(producer);
	}
	
	public Iterable<Producer> getAllProducers(){
		return producerRepository.findAll();
	}
	
	public Producer getProducerById(int producer_id) {
		return producerRepository.findById(producer_id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Producer producer = producerRepository.findByEmailAddress(username);
		if (producer != null) {
			return new ProducerWrapper(producer);
		}
		throw new UsernameNotFoundException("producer could not be located");
	}
}
