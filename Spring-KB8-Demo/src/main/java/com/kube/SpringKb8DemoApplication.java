package com.kube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringKb8DemoApplication {
	
	
	@GetMapping("/hello")
	public String helloMessage() {
		return "This is msg from app deployed in K8";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringKb8DemoApplication.class, args);
	}

}
