package com.example.bootweb.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootweb.mapper.TestMapper;
import com.example.bootweb.service.inf.TestService;

@RestController
public class TestController {

	@Autowired
	TestService testService;
	@GetMapping("/aaa")
	public Object aaa() {
		return testService.test();
	}
	
}
