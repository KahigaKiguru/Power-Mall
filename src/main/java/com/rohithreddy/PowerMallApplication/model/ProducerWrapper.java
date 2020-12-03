package com.rohithreddy.PowerMallApplication.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ProducerWrapper implements UserDetails {

	private Producer producer;

	public ProducerWrapper(Producer producer) {
		super();
		this.producer = producer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<Role> producer_roles = producer.getRoles();
		
		List<SimpleGrantedAuthority> producer_authorities = new ArrayList<>();
		
		for (Role role : producer_roles) {
			producer_authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return producer_authorities;
	}

	@Override
	public String getPassword() {
		return producer.getPassword();
	}

	@Override
	public String getUsername() {
		return producer.getEmailAddress();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public int getProducerId() {
		return producer.getId();
	}
}
