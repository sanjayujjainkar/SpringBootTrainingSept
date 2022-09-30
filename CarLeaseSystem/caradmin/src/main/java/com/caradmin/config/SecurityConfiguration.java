package com.caradmin.config;

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
		.antMatchers(HttpMethod.GET, "/admin/**").hasAnyRole("ADMIN", "BROKER")
		.antMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/admin/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/admin/**").hasRole("ADMIN")
		.and().csrf().disable().headers()
		.frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("admin123").password("{noop}password").roles("ADMIN").and()
		.withUser("broker123").password("{noop}password").roles("BROKER");
	}

}
