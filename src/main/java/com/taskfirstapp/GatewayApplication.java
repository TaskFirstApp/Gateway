package com.taskfirstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Contract;

@EnableZuulProxy
@EnableEurekaClient 
@EnableFeignClients
@SpringBootApplication
public class GatewayApplication {

	@Bean
	public Contract feignContract() {
		return new Contract.Default();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
