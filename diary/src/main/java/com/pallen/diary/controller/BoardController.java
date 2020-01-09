package com.pallen.diary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pallen.diary.dto.PagingDTO;
import com.pallen.diary.entity.board.Board;
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
			log.info(request.getParameter("pg"));
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		PagingDTO paging = new PagingDTO(page);
		List<Board> brdList = new ArrayList<>();
		boardService.list(page, paging.getCol_cnt()).forEach(e -> brdList.add(e));
		log.info("brd : {}",brdList);
		log.info("page:{}",page);
		model.addAttribute("paging", paging);
		model.addAttribute("brdList", brdList);
		
		return "/page/board/list";
	}
	
	private String getIpAddress(HttpServletRequest request) {
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
