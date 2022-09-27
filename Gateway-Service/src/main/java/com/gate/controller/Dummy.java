package com.gate.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public class Dummy {

	/*
	 * public String getSchoolDetail(@PathVariable String schoolname) { HttpHeaders
	 * headers = new HttpHeaders(); HttpEntity<String> entity = new
	 * HttpEntity<String>(headers); String URL =
	 * "http://school.service/schoolDetail/" + schoolname; ResponseEntity<String>
	 * response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
	 * 
	 * String responseBody =
	 * restTemplate.exchange("http://school.service/schoolDetail/{schoolname}",
	 * HttpMethod.GET, null, new ParameterizedTypeReference<String>()).getBody();
	 * 
	 * 
	 * String responseBody = response.getBody(); String responseStr = "School Name:"
	 * + schoolname + "\n Student Detail:"+responseBody; return responseStr; }
	 */

}
