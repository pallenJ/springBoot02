package com.pallen.diary.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.service.BoardService;
import com.pallen.diary.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/userInfo/*")
public class UserInfoController {
	
	@Resource
	private UserService userService;
	@Resource
	private BoardService boardService;
	
	@GetMapping("/{name}")
	public String userInfo(@PathVariable("name") String name, ModelMap model) {
//		User user = userService.getByName(name);
//		model.addAttribute("user", user);
		model.addAttribute("userName", name);
		//model.addAttribute("brdList",boardService.listByUser(user));
		
		return "/page/user/userDetail";
	}
	
	@GetMapping("/{name}/brdList")
	public String userInfo_list(@PathVariable("name") String name, ModelMap model) {
		User user = userService.getByName(name);
		model.addAttribute("user", user);
		model.addAttribute("brdList",boardService.listByUser(user));
		
		return "/page/user/userDetail_list";
	}
	
}
