package com.example.bootweb01.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String login(@RequestParam("code") String code, HttpSession session) {
		 String access_Token = kakaoAPI.getAccessToken(code);
		    Map<String, Object> userInfo = kakaoAPI.getUserInfo(access_Token);
		    log.info("login Controller : {}" , userInfo);
		    
		    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
		    if (userInfo.get("email") != null) {
		        session.setAttribute("userId", userInfo.get("email"));
		        session.setAttribute("access_Token", access_Token);
		    }
		    return "index";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
	    kakaoAPI.kakaoLogout((String)session.getAttribute("access_Token"));
	    session.removeAttribute("access_Token");
	    session.removeAttribute("userId");
	    return "index";
	}

}
