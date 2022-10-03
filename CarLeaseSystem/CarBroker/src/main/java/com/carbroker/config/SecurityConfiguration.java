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
		//TODO Auto-generated method stub 
		http.httpBasic().and().authorizeRequests()
		  .antMatchers(HttpMethod.GET, "/broker/**").hasAnyRole("ADMIN", "USER") 
		  .antMatchers(HttpMethod.POST, "/broker/**").hasRole("ADMIN")
		  .antMatchers(HttpMethod.PUT, "/broker/**").hasRole("ADMIN")
		  .antMatchers(HttpMethod.DELETE, "/broker/**").hasRole("ADMIN")
		  .and().csrf().disable().headers() .frameOptions().disable(); 
	}

	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		// TODO Auto-generated method stub 
		auth.inMemoryAuthentication()
		  .withUser("admin123").password("{noop}password").roles("ADMIN").and()
		  .withUser("user123").password("{noop}password").roles("USER").and()
		  .withUser("admin").password("{noop}password").roles("ADMIN"); 
	}

}
