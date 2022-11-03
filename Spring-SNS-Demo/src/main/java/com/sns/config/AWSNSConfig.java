package com.sns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

public class AWSNSConfig {
	
	private static final String access_key = "AKIA4MFLODBGAT3YKLGX";
	private static final String secret_key = "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";
		
	
	@Primary
	@Bean
	public AmazonSNSClient getSNSClient() {
		
		return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(access_key, secret_key)))
				.build();
		
	}

}
