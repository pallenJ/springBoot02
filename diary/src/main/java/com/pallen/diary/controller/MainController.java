package com.pallen.diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/Main/*")
@Controller
public class MainController {
	@GetMapping("/Main")
	public String mainPage() {
		return "/page/main";
	}
}
