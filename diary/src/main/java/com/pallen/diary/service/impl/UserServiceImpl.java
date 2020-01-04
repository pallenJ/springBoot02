package com.pallen.diary.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
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
