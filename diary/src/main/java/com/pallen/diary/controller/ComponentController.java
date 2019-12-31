package com.pallen.diary.controller;

import javax.servlet.http.HttpSession;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pallen.diary.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/components/*")
@Controller
public class ComponentController {
	
	@GetMapping("login")
	public void login(ModelMap model) {
		
	}
	@PostMapping("login")
	public String login(HttpSession session,
			@Param(value = "email") String email,@Param(value = "password")String pw) {
		
		return "redirect:/Main";
	}
	
	@GetMapping("register")
	public void register(ModelMap model) {
		
	}
	
	@PostMapping("register")
	public String register(HttpSession session,User user) {
		return "redirect:/Main";
	}
	
}
