package com.sqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude= {ContextStackAutoConfiguration.class})
@RestController
public class SpringAwsSqsApplication {
	
	Logger logger = LoggerFactory.getLogger(SpringAwsSqsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsSqsApplication.class, args);
	}
	
	@Autowired
	private QueueMessagingTemplate queueTemplate;
	
	
	@Value("${cloud.aws.end-point.uri}")
	private String endpoint;
	
	@GetMapping("/send/{message}")
	public void sendMessageToQueue(@PathVariable String msg) {
		queueTemplate.send(endpoint, MessageBuilder.withPayload(msg).build());
	}
	
	@SqsListener("queue-Sanjay")
	public void loadMessageFromSQS(String msg) {
		logger.info("Message from the Q is:{}", msg);
	}

}
