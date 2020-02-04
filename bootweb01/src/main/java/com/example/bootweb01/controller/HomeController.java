package com.example.bootweb01.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bootweb01.service.KakaoAPI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private KakaoAPI kakaoAPI;
	
	@GetMapping(value = {"/", "/Main", "Home"})
	public String index() {
		return "index";
	}
	@GetMapping(value="/login")
	public String login(@RequestParam("code") String code) {
	    log.info("code : {}", code);
	    String accessToken = kakaoAPI.getAccessToken(code);
		log.info("controller access_token : {}", accessToken);
	    return "index";
	}

}
