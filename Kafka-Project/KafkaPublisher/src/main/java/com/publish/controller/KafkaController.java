package com.publish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@GetMapping("/kafka/{message}")
	public String publishMessage(@PathVariable String message) {
		kafkaTemplate.send("spring-kafka","This is message from Kafka server:"+message);
		return "Message is published to Kafka";
	}

}
