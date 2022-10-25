package com.gate.controller;
/*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.BadCredentialsException; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.gate.model.AuthenticationRequest; import
 * com.gate.model.AuthenticationResponse; import
 * com.gate.services.CarLeaseUserDetailService; import com.gate.utils.JWTUtils;
 * 
 * //@RestController public class GatewayController {
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @Autowired private JWTUtils jwtUtils;
 * 
 * @Autowired private CarLeaseUserDetailService userDetailsService;
 * 
 * @GetMapping("/getMessage") public String getMessage() { return
 * "This is test message"; }
 * 
 * @PostMapping("/authenticate") //"/login" public ResponseEntity<?>
 * createAuthToken(@RequestBody AuthenticationRequest authRequest) throws
 * Exception { try { authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken(authRequest.getUsername(),
 * authRequest.getPassword())); } catch (BadCredentialsException e) { throw new
 * Exception("Wrong credentials", e); }
 * 
 * final UserDetails userDetails =
 * userDetailsService.loadUserByUsername(authRequest.getUsername());
 * 
 * final String jwt = jwtUtils.generateToken(userDetails);
 * 
 * return ResponseEntity.ok(new AuthenticationResponse(jwt));
 * 
 * }
 * 
 * }
 */
