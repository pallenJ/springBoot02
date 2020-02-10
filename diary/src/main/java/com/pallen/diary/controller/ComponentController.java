package com.pallen.diary.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.service.UserService;
import com.pallen.diary.service.api.KakaoAPI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/components/*")
@Controller
public class ComponentController {
	
	@Resource
	private UserService userService;
	@Autowired
	private KakaoAPI kakaoAPI;
	/* user */
	
	@GetMapping("register")
	public void register(ModelMap model) {
		
	}
	
	@PostMapping("register")
	public String register(HttpSession session,User user) {
		log.info("new user :{}",user);
		userService.register(user);
		return "redirect:/Main";
	}
	
	@PostMapping("/userExist")
	@ResponseBody
	public boolean userExist(String email) {
		log.info(email);
		try {
		  userService.get(email);
		
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@PostMapping("/nameExist")
	@ResponseBody
	public boolean nameExist(String name) {
		log.info(name);
		try {
			userService.getByName(name);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@GetMapping("login")
	public void login(HttpSession session,ModelMap model) {
		if(session.getAttribute("loginUser")!=null) {
			session.removeAttribute("loginUser");
			session.removeAttribute("loginUserEmail");
		}
	}
	
	@PostMapping("login")
	public String login(HttpSession session,
			String email,@RequestParam(value = "password")String pw) {
			
			try {
				User user = userService.get(email);
				if(!pw.equals(user.getPassword())) 
					throw new Exception();
				session.setAttribute("loginUser", user);
				session.setAttribute("loginUserEmail", user.getEmail());
				session.setAttribute("loginBy", "NORMAL");
				log.info("로그인 성공");
			} catch (Exception e) {
				log.info("로그인 실패");
			}
		return "redirect:/Main";
	}
	@GetMapping("logout")
	public String logout(HttpSession session,ModelMap model) {
		session.removeAttribute("loginUser");
		String loginBy=(String)(session.getAttribute("loginBy"));
		if(!loginBy.equals("NORMAL")) {
			snsLogout(session,loginBy);
		}
		
		return "redirect:/Main";
	}
	
	/*user end*/
	

	@GetMapping("brdList")
	public void brdList(ModelMap model) {
		
	}
	private void snsLogout(HttpSession session,String loginBy) {
		
		switch (loginBy) {
		case "kakao":
			log.info("kakao logout");
			kakaoAPI.kakaoLogout((String)session.getAttribute("access_Token"));
		    session.removeAttribute("access_Token");
			break;

		default:
			break;
		}
	}
}
