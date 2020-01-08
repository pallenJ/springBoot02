package com.pallen.diary.controller;

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

@Controller
@Slf4j
public class MainController {
	
	@Resource
	private BoardService boardService;
	
	@GetMapping("/Main")
	public String mainPage(HttpServletRequest request,ModelMap model) {
//		log.info(request.getParameter("pg")+"");
//		model.addAttribute("pg",request.getParameter("pg"));
		return "/page/main";
	}
}
