package com.example.bootweb01.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

	@GetMapping(value = {"/", "/Main", "Home"})
	public String index() {
		return "index";
	}
	
}
