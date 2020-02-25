package com.example.bootweb01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NaverController {

	@GetMapping("/naver/login")
	public void login(HttpServletRequest request) {
		String access_tocken = "";
		boolean contain = request.getParameterMap().keySet().contains("access_tocken");
		if(contain)access_tocken = request.getParameter("access_tocken");
		
		log.info("access_tocken:{}",access_tocken);
	}
	
	@GetMapping("/naver/loginCallBack")
	public void loginCmpt() {}
	
}
