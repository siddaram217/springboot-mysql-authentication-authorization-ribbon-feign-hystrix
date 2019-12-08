package com.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.candidate.feign.client")
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class CandidateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateServiceApplication.class, args);
	}

}
