package com.pallen.diary.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.UserService;
import com.pallen.diary.service.api.KakaoAPI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	@Override
	public User getByName(String name) {
		log.info(name);
		log.info(userRepository.findByName(name).toString());
		return userRepository.findByName(name).get(0);
	}
	@Override
	public boolean exist(String email, String name) {
		return userRepository.countByEmailOrName(email, name)>0;
	}

	@Override
	public boolean exist(String email) {
		// TODO Auto-generated method stub
		return userRepository.countByEmail(email)>0;
	}


	
}
