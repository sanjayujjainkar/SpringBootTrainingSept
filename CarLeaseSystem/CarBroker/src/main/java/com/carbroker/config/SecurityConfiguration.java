package com.carbroker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/broker/**").hasAnyRole("OWNER", "BROKER")
		.antMatchers(HttpMethod.POST, "/broker/**").hasRole("BROKER")
		.antMatchers(HttpMethod.PUT, "/broker/**").hasRole("BROKER")
		.antMatchers(HttpMethod.DELETE, "/broker/**").hasRole("BROKER")
		.and().csrf().disable().headers()
		.frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("owner123").password("{noop}password").roles("OWNER").and()
		.withUser("broker123").password("{noop}password").roles("BROKER").and()
		.withUser("broker").password("{noop}password").roles("BROKER");
	}

}
