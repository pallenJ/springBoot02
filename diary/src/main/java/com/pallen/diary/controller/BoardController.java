package com.pallen.diary.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pallen.diary.dto.PagingDTO;
import com.pallen.diary.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@GetMapping("list")
	public String list(HttpServletRequest request , ModelMap model) {
		int page = 1;
		try {
			page = (int) request.getAttribute("pg");
		} catch (Exception e) {
			// TODO: handle exception
		}
		PagingDTO paging = new PagingDTO(page);
		model.addAttribute("paging", paging);
		model.addAttribute("brdList", boardService.list(page, paging.getAmount()));
		return "/page/board/list";
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
