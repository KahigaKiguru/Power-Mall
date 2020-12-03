package com.rohithreddy.PowerMallApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rohithreddy.PowerMallApplication.service.ConsumerService;

@Configuration
@Order(1)
public class ConsumerSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	ConsumerService consumerService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(consumerService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	       http.antMatcher("/consumer/**")
           .authorizeRequests()
           .antMatchers("/producer/**", "/consumer/**", "/css/**", "/images/**")
           .permitAll()
           .anyRequest()
           .authenticated()
           .and()
           .formLogin()
           .loginPage("/consumer/loginPage")
           .defaultSuccessUrl("/consumer/consumerPage")
           .permitAll(true)
           .and()
           .logout()
           .logoutUrl("/consumer/logout")
           .logoutSuccessUrl("/consumer/loginPage")//our new logout success url, we are not replacing other defaults.
           .permitAll();//allow all as it will be accessed when user is not logged in anymore
   http.csrf().disable();
	}
	
	
	
}
