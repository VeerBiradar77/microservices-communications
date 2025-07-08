package com.demo.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.user.domain.Ratings;
import com.demo.user.domain.User;
import com.demo.user.exceptions.ResourceNotFoundException;
import com.demo.user.repository.UserRepository;
import com.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server !!:" + userId));

		// fetch rating of above user from Rating-Service
		// Using REST Template for communication between services - Synchronous commu.
		// http://localhost:8083/ratings/users/db338865-8555-4eab-a85c-2165bf7847ac

		ArrayList<Ratings> ratingOfUser = restTemplate
				.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
		logger.info("{} ", ratingOfUser);

		user.setRatings(ratingOfUser);

		return user;

	}

}
