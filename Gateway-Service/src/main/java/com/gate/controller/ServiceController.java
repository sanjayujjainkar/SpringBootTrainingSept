package com.gate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value="/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
	public String getSchoolDetail(@PathVariable String schoolname) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String URL = "http://school.service/schoolDetail/" + schoolname;
		ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
				
		String responseBody = response.getBody();
		String responseStr = "School Name:" + schoolname + "\n Student Detail:"+responseBody;
		return responseStr;
	}
	
	
	
}
