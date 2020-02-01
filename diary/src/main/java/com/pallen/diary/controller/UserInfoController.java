package com.pallen.diary.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pallen.diary.dto.PagingDTO;
import com.pallen.diary.entity.board.Board;
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
		model.addAttribute("userName", name);
		return "/page/user/userDetail";
	}
	
	@GetMapping("/{name}/brdList")
	public String userInfo_list(@PathVariable("name") String name,HttpServletRequest request, ModelMap model) {
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		User user = userService.getByName(name);
		List<Board> brdList = user.getBoardList();
		Collections.reverse(brdList);
		PagingDTO paging = new PagingDTO(page,user.getBoardList().size());
		int tempPG = (page - 1 )*paging.getCol_cnt();
		model.addAttribute("user", user);
		model.addAttribute("brdList",brdList.subList(tempPG, tempPG+paging.getCol_cnt()));
		model.addAttribute("paging",paging);
		return "/page/user/userDetail_list";
	}
	
}
