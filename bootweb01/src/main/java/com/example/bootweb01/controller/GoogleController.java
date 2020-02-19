package com.example.bootweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/google/*")
public class GoogleController {
	@GetMapping("/login")
	public String main() {
		return "/google/login";
	}
	@PostMapping("/login")
	public String login(String email, String name) {
		log.info("email :{}, nickname : {}",email,name);
		return "/google/login";
	}
	
}
