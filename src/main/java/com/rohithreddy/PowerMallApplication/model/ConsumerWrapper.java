package com.rohithreddy.PowerMallApplication.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ConsumerWrapper implements UserDetails{

	private Consumer consumer;

	
	public ConsumerWrapper(Consumer consumer) {
		super();
		this.consumer = consumer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<Role> consumer_roles = consumer.getRoles();
		
		List<SimpleGrantedAuthority> consumer_authorites = new ArrayList<>();
		
		for (Role role : consumer_roles) {
			consumer_authorites.add(new SimpleGrantedAuthority(role.getName()));
		}
		return consumer_authorites;
	}

	@Override
	public String getPassword() {
		return consumer.getPassword();
	}

	@Override
	public String getUsername() {
		return consumer.getEmailAddress();
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
	
	public int getId() {
		return consumer.getId();
	}
	
	public String name() {
		return consumer.getName();
		
	}
}
