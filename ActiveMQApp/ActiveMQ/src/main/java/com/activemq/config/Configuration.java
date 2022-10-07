package com.activemq.config;

import javax.jms.JMSConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Value("${activemq.broker-url}")
	private String BROKER_URL;

	@Bean
	public Queue queue( ) {
		return new ActiveMQQueue("standalone-queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URL);
		//factory.setUserName("admin");
		//factory.setPassword("admin");
		return factory;
	}

	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
