package com.rohithreddy.PowerMallApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rohithreddy.PowerMallApplication.service.ProducerService;

@Configuration
@Order(2)
public class ProducerSecurity extends WebSecurityConfigurerAdapter {

	@Autowired 
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	ProducerService producerService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(producerService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	       http.antMatcher("/producer/**")
           .authorizeRequests()
           .antMatchers("/producer/**", "/consumer/**", "/css/**", "/images/**")
           .permitAll()
           .anyRequest()
           .authenticated()
           .and()
           .formLogin()
           .loginPage("/producer/loginPage")
           .defaultSuccessUrl("/producer/producerrPage")
           .permitAll(true)
           .and()
           .logout()
           .logoutUrl("/producer/logout")
           .logoutSuccessUrl("/producer/loginPage")
           .permitAll();
   http.csrf().disable();
	}
	
	
	
}
