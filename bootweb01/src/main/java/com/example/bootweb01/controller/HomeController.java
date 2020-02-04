package com.example.bootweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping(value = {"/", "/Main", "Home"})
	public String index() {
		return "index";
	}
	@GetMapping(value="/login")
	public String login(@RequestParam("code") String code) {
	    log.info("code : {}", code);
	    return "index";
	}

}
