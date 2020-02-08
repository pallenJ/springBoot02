package com.pallen.diary.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pallen.diary.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/")
	public String home() {
		log.info("idx");
		return "index";
	}
	
	@GetMapping("{type}_login")
	public String snsLogin(@PathVariable("type")String login_type, HttpServletRequest request) {
		switch (login_type) {
		case "kakao":
			String code = (String)request.getParameter("code");
			Map<String, Object> paramInfo = new HashMap<String, Object>();
			paramInfo.put("code", code);
			log.info("code:{}",code);
			Object email = (userService.snsLogin(login_type, paramInfo).get("email"));
			log.info("email:{}",email);
			//log.info(userService.get(email)==null?"실패":"성공");
			
			break;

		default:
			break;
		}
		return "index";
	}
}
