package com.pallen.diary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pallen.diary.entity.User;
import com.pallen.diary.repository.UserRepository;
import com.pallen.diary.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void register(User user) {
		userRepository.save(user);
	}

	@Override
	public User get(String email) {
		return userRepository.findById(email).get();
	}

}
