package com.gate.config;

/*
 * import javax.servlet.Filter;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.config.web.server.ServerHttpSecurity; import
 * org.springframework.security.core.SpringSecurityMessageSource; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * org.springframework.security.web.server.SecurityWebFilterChain;
 * 
 * import com.gate.filter.JwtRequestFilter; import com.gate.utils.JWTUtils;
 */


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailService;
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
//		auth.userDetailsService(userDetailService);
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeRequests().antMatchers("/authenticate").permitAll().
//				anyRequest().authenticated().and().
//				exceptionHandling().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}
	
//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http.csrf(csrf -> csrf.disable());
//		return http.build();
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
//	@Bean
//	public JWTUtils getJWTUtils() {
//		return new JWTUtils();
//	}
	
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

//}
