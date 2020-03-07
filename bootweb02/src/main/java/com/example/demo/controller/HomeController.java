package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String main() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		log.info("login page");
		return "/login";
	}
	@PostMapping("/login")
	public String login(String username,String password) {
		log.info("username:{}",username);
		return "index";
	}
	@GetMapping("/admin")
	public String admintest() {
		return "/admin/admin_test";
	}
}
