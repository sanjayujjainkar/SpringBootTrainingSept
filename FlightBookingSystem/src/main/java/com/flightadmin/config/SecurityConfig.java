package com.flightadmin.config;

/*
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

 
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/admin/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/admin/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/admin/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/admin/**").hasAnyRole("ADMIN", "USER")
		.and().csrf().disable().headers().frameOptions().disable(); 
		//.antMatchers("/admin/**").hasRole("ADMIN")
		//.and().csrf().disable();
		//.antMatchers(HttpMethod.PUT, "/admin/**").authenticated()
		//.antMatchers(HttpMethod.GET, "/admin/**").authenticated();
		//.and().csrf().disable().headers().frameOptions().disable(); 
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		auth.inMemoryAuthentication()
		
		.withUser("user123").password("{noop}password").roles("ADMIN").and()
		.withUser("admin123").password("{noop}password").roles("ADMIN").and()
		.withUser("test123").password("{noop}password").roles("ADMIN").and()
		.withUser("admin1").password("{noop}password").roles("ADMIN");
	}

}

*/