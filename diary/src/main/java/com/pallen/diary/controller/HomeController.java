package com.pallen.diary.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pallen.diary.service.UserService;
import com.pallen.diary.service.api.KakaoAPI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Resource
	private UserService userService;

	@Autowired
	KakaoAPI kakaoAPI;

	@RequestMapping("/")
	public String home() {
		log.info("idx");
		return "index";
	}

	@GetMapping("{sns}_login")
	public String kakaoLogin(HttpSession session, HttpServletRequest request,
			@PathVariable("sns")String loginBy) {
			snsLogin(session, request, loginBy);
			return "index";
	}
	
	private void snsLogin(HttpSession session, HttpServletRequest request,String loginBy) {
		
		switch (loginBy) {
		case "kakao":
			String code = (String) request.getParameter("code");
			log.info("kakao code : {}",code);
			String access_Token = kakaoAPI.getAccessToken(code,"login");
			Map<String, Object> userInfo = kakaoAPI.getUserInfo(access_Token);
			log.info("login Controller : {}", userInfo);
			
			// 클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
			if (userInfo.get("email") != null) {
				String email = (String)userInfo.get("email");
				session.setAttribute("loginUser", userService.get(email));
				session.setAttribute("access_Token", access_Token);
				session.setAttribute("loginBy", loginBy);
				log.info("email : {}",userInfo.get("email").toString());
			}

			break;

		default:
			break;
		}
		
	}
	
	
}
