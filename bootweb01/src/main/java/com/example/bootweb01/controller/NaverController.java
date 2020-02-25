package com.example.bootweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverController {

	@GetMapping("/naver/login")
	public void login() {}
	
	@GetMapping("/naver/loginCallBack")
	public void loginCmpt() {}
	
}
