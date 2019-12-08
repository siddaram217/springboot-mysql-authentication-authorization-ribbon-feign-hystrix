package com.candidate.feign.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfiguration {
	
	@Value(value="${employee-service.application.fid}")
	private String username;
	
	@Value(value="${employee-service.application.fpwd}")
	private String password;
	
	private static final Logger logger = LoggerFactory.getLogger(FeignClientConfiguration.class);
	
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    logger.info("FeignClientConfiguration.basicAuthRequestInterceptor() -> "+username +" - "+password);
		return new BasicAuthRequestInterceptor(username, password);
    }
}
