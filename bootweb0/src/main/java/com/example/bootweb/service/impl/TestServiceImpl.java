package com.example.bootweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootweb.mapper.TestMapper;
import com.example.bootweb.service.inf.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public Object test() {
		// TODO Auto-generated method stub
		return testMapper.now();
	}

}
