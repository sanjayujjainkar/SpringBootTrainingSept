package com.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "standalone-queue")
	public String consumeMessage(String msg) {
		System.out.println("Message Consumed:"+ msg);
		return msg;
	}
	
}
