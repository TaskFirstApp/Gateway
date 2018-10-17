package com.taskfirstapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taskfirstapp.entity.TaskUserDetails;
import com.taskfirstapp.util.Util;

@Service
public class TaskUserDetailsService implements UserDetailsService {

	@Autowired
	UserFeignClient userFeignClient;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		TaskUserDetails taskUserDetails = Util.readValue(userFeignClient.findUserByUsername(userName),
				TaskUserDetails.class);
		return taskUserDetails;
	}

}
