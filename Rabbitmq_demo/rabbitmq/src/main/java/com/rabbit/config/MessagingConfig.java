package com.rabbit.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MessagingConfig {

	public static final String QUEUENAME = "employee-rountingKey";
	public static String ROUNTING_KEY = "employee-rountingKey";
	public static String EXCHANGENAME = "employee-exchange";
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Queue queue() {
		return new Queue(QUEUENAME);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGENAME);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange ) {
		return BindingBuilder.bind(queue).to(topicExchange).with(ROUNTING_KEY);
	}
	
	@Bean
	public MessageConverter conveter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(conveter());
		return rabbitTemplate;
	}
}
