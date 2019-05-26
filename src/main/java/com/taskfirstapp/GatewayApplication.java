package com.taskfirstapp;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskfirstapp.security.UserFeignClient;

import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.Encoder.Default;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;


@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RestController
public class GatewayApplication {

	@Autowired
	UserFeignClient userFeignClient;

	@Bean
	public Contract feignContract() {
		return new Contract.Default();
	}
	
	@Bean
	public Encoder getEncoder() {
		return new GsonEncoder();
	}
	
	@Bean
	public Decoder getDecoder() {
		return new GsonDecoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		Map<String, String> user = new HashMap<>();
		user.put("username", principal.getName());
		user.put("password", "SSO");
		userFeignClient.addUser(user);

		return principal;
	}
}
