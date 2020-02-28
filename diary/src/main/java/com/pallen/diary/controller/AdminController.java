package com.pallen.diary.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {

	@Resource
	private AdminService adminService;
	
	@GetMapping("/admin/userList")
	public String userList(HttpSession session, ModelMap model,RedirectAttributes rttr) {
		
		try {
			Object loginUser = session.getAttribute("loginUser");
			User user = (User)loginUser;
			if(!user.getGrade().equals("ADMIN")) {} 
		} catch (Exception e) {
			// TODO: handle exception
			//rttr.addAttribute("modal_message", "접근할 수 있는 권한이 없습니다.");
			log.info("error:{}", "접근할 수 있는 권한이 없습니다.");
			return "redirect:/Main";
		}
		model.addAttribute("userList",adminService.userListAll());
		return "/page/admin/admin_userList";
	}
	
	
}
