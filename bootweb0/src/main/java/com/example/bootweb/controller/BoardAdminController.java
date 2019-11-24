package com.example.bootweb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bootweb.domain.Criteria;
import com.example.bootweb.domain.PagingView;
import com.example.bootweb.service.inf.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/admin/*")
@Controller
public class BoardAdminController {
	
	@Resource
	private BoardService boardService;
	
	
	
	@GetMapping("{state}List")
	public String stateList(@PathVariable("state")String state, Model model, HttpServletRequest request) {
		state = state.toUpperCase();
		int pageNum = 1;
		int amount = 10;
		int max = boardService.stateCnt(state);
		log.info("max:"+max);
		try {
			pageNum = Integer.parseInt(request.getParameter("p"));
			amount = Integer.parseInt(request.getParameter("amt"));
		} catch (Exception e) {}
		Criteria cri = new Criteria(pageNum, amount, max);
		List<?> list = 	boardService.stateList(cri, state.toUpperCase());
		log.info(cri.toString());	
		log.info(new PagingView(cri).toString());	
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingView(cri));
		model.addAttribute("amount",amount);
		return "board/admin/stateList";
	}
}
