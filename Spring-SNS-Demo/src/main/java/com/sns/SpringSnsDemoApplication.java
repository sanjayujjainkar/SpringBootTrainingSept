package com.sns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
@RestController
public class SpringSnsDemoApplication {
	
	@Autowired
	private AmazonSNSClient amazonSNSClient;
	
	private static String TOPIC_ARN = "arn:aws:sns:us-east-1:850763061324:topic-sanjay";
	
	private static String MSG = "Dear Customer\nGreeting from our store.\nWe are offering flat 60% discount on all purchase";
	
	@GetMapping("/subscription/{email}")
	public String addSubscription(@PathVariable String email) {
		SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN, "email", email);
		amazonSNSClient.subscribe(subscribeRequest);
		return "Subscription request is pending, To confirm, check your email:"+email;
	}
	
	@GetMapping("/sendNotification")
	public String publishMessage() {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, MSG, "Sub-MessageFromSpringBootApp");
		amazonSNSClient.publish(publishRequest);
		return "Message Notification Published Successfully";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSnsDemoApplication.class, args);
	}

}
