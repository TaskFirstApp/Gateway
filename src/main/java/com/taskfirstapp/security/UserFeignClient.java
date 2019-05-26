package com.taskfirstapp.security;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import com.taskfirstapp.security.UserFeignClient.UserFeignClientFallback;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@FeignClient(name = "Users", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
	@RequestLine(value = "GET /users/{username}")
	public String findUserByUsername(@Param("username") String username);
	
	@RequestLine(value = "POST /users")
	@Headers("Content-Type: application/json")
	public Map<String, ?> addUser(Map<String, ?> user);

	@Component
	public static class UserFeignClientFallback implements UserFeignClient{
		public String findUserByUsername(String username) {
			return null;
		}

		@Override
		public Map<String, ?> addUser(Map<String, ?> user) {
			return null;
		}
	}
}
