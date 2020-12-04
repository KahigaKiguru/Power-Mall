package com.rohithreddy.PowerMallApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rohithreddy.PowerMallApplication.service.UserService;

@Configuration
public class UserSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	       http.antMatcher("/**")
           .authorizeRequests()
           .antMatchers("/**", "/css/**", "/images/**")
           .permitAll()
           .anyRequest()
           .authenticated()
           .and()
           .formLogin()
           .loginPage("/login")
           .defaultSuccessUrl("/index", true)
           .permitAll(true)
           .and()
           .logout()
           .logoutUrl("/logout")
           .logoutSuccessUrl("/login")
           .permitAll();
   http.csrf().disable();
	}
	
	
	
}
