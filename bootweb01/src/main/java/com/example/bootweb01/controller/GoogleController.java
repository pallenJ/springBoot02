package com.example.bootweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/google/*")
public class GoogleController {
	@GetMapping("/login")
	public String main() {
		return "/google/login";
	}
}
