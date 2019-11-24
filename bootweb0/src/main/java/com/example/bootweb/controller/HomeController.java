package com.example.bootweb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.cookie.ClientCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Resource
	HttpSession session;

	String[] themes = new String[]{"cerulean", "cosmo", "cyborg", "darkly", "flatly", "journal", "litera",
			"lumen", "lux", "materia", "minty", "pulse", "sandstone", "simplex", "sketchy", "slate", "solar",
			"spacelab", "superhero", "united", "yeti"};
	
	@GetMapping("/")
	public String home() {
		if(session.getAttribute("designTheme")==null||session.getAttribute("designTheme").equals(""))
		session.setAttribute("designTheme", themes[4]);
		return "index";
	}

	@GetMapping("/login")
	public void login(HttpServletRequest request, Model model) {
		
	}
	
	@ResponseBody
	@PostMapping(value = "/thm_change") 
	public void themeChange(String theme) {
		session.setAttribute("designTheme", theme);
	}
	
}
