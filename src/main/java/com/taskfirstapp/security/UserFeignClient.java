package com.taskfirstapp.security;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import com.taskfirstapp.security.UserFeignClient.UserFeignClientFallback;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "users", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
	@RequestLine(value = "GET /users/{username}")
	public String findUserByUsername(@Param("username") String username);

	@Component
	public static class UserFeignClientFallback implements UserFeignClient{
		public String findUserByUsername(String username) {
			return null;
		}
	}
}
