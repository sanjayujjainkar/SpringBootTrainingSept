package com.school.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/schoolDetail")
public class SchoolServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/{school}")
	String getStudent(@PathVariable("school") String school) {
		//String requestURL = "http://localhost:9091/getStudentDetailForSchool/"+school;
		String requestURL = "http://student.service/getStudentDetailForSchool/"+school;
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<String> response = restTemplate.exchange(requestURL, HttpMethod.GET, entity, String.class);
		
		String student = response.getBody();
		System.out.println("Name of School:"+ school + "\n");
		System.out.println("Name of Student:"+ student);
		String strhtml = "<html><h1>My School Detail</h2></br></html>";
		return strhtml + school + "," + student;
		
	}

}
