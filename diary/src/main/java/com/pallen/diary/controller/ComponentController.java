package com.pallen.diary.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/components/*")
@Controller
public class ComponentController {
	
	@Resource
	private UserService userService;
	
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
	
	@GetMapping("login")
	public void login(HttpSession session,ModelMap model) {
		if(session.getAttribute("loginUser")!=null) {
			session.removeAttribute("loginUser");
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
				log.info("로그인 성공");
			} catch (Exception e) {
				log.info("로그인 실패");
			}
		return "redirect:/Main";
	}
	@GetMapping("logout")
	public String logout(HttpSession session,ModelMap model) {
		session.removeAttribute("loginUser");
		return "redirect:/Main";
	}
	
	
	
	private String getIpAdress(HttpServletRequest request) {
		 String ip = request.getHeader("X-Forwarded-For");
		 
	        log.info(">>>> X-FORWARDED-FOR : " + ip);
	 
	        if (ip == null) {
	            ip = request.getHeader("Proxy-Client-IP");
	            log.info(">>>> Proxy-Client-IP : " + ip);
	        }
	        if (ip == null) {
	            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
	            log.info(">>>> WL-Proxy-Client-IP : " + ip);
	        }
	        if (ip == null) {
	            ip = request.getHeader("HTTP_CLIENT_IP");
	            log.info(">>>> HTTP_CLIENT_IP : " + ip);
	        }
	        if (ip == null) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	            log.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
	        }
	        if (ip == null) {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	    
	} 
	
	
}
