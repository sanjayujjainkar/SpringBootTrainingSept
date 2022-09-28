package com.gate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 * @RestController public class ServiceController {
 * 
 * @Autowired private RestTemplate restTemplate; private HttpHeaders
 * httpHeaders; private HttpEntity<String> entity;
 * 
 * public ServiceController() { httpHeaders = new HttpHeaders(); entity = new
 * HttpEntity<>(httpHeaders); }
 * 
 * @RequestMapping(value = "/getSchoolDetails/{schoolname}", method =
 * RequestMethod.GET) public String getSchoolDetail(@PathVariable String
 * schoolname) {
 * 
 * String URL = "http://school.service/schoolDetail/" + schoolname;
 * ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET,
 * entity, String.class);
 * 
 * String responseBody = response.getBody(); String responseStr = "School Name:"
 * + schoolname + "\n Student Detail:" + responseBody; return responseStr; }
 * 
 * 
 * @GetMapping("/getFlights")
 * 
 * @RequestMapping(value="/getFlights", method = RequestMethod.GET) public
 * String getAllFlights() { String URL = "http://localhost:8091/getFlights";
 * ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET,
 * entity, String.class); String responseBody = response.getBody(); return
 * responseBody; }
 * 
 * 
 * 
 * }
 */