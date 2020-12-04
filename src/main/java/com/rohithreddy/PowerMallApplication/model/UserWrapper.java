package com.rohithreddy.PowerMallApplication.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserWrapper implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5577640933292143186L;
	private User user;

	public UserWrapper(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<Role> producer_roles = user.getRoles();
		
		List<SimpleGrantedAuthority> producer_authorities = new ArrayList<>();
		
		for (Role role : producer_roles) {
			producer_authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return producer_authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
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
		return user.getId();
	}
}
