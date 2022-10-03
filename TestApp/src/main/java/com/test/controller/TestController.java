package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.AuthenticationRequest;
import com.test.model.AuthenticationResponse;
import com.test.service.MyUserService;
import com.test.utils.JWTUtils;
import com.test.utils.Utils;

@RestController
public class TestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@Autowired
	private MyUserService userDetailsService;
	
	@GetMapping("/getMessage")
	public String getMessage() {
		return "This is test message";
	}
	
	@PostMapping("/authenticate") //"/login"
	public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		}
		catch (BadCredentialsException  e) {
			throw new Exception("Wrong credentials", e);
		}
		
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authRequest.getUsername());

		final String jwt = jwtUtils.generateToken(userDetails);
		
		Utils.username = authRequest.getUsername();
		Utils.isValidToken = jwtUtils.validateToken(jwt, userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	/*
	 * @PostMapping("/login") //"/login" public ResponseEntity<?>
	 * createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
	 * throws Exception {
	 * 
	 * try { authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(authRequest.getUsername(),
	 * authRequest.getPassword())); } catch (BadCredentialsException e) { throw new
	 * Exception("Wrong credentials", e); }
	 * 
	 * final UserDetails userDetails = userDetailsService
	 * .loadUserByUsername(authRequest.getUsername());
	 * 
	 * final String jwt = jwtUtils.generateToken(userDetails);
	 * 
	 * return ResponseEntity.ok(new AuthenticationResponse(jwt));
	 * 
	 * 
	 * }
	 */
	

}
