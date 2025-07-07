package com.demo.user.service;

import java.util.List;

import com.demo.user.domain.User;

public interface UserService{
	
	User saveUser (User user);
	
	List<User> getAllUser();
	
	User getUser (String userId);
	

}
