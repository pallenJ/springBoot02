package com.pallen.diary.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Resource
	private UserRepository userRepository;
	
	@Override
	public List<User> userListAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<User> userList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
