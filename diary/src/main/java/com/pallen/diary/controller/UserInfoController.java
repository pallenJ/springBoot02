package com.pallen.diary.controller;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/myInfo")
	public String myInfo(HttpSession session, ModelMap model) {
		User user = (User)(session.getAttribute("loginUser"));
		model.addAttribute("userName", user.getName());
		model.addAttribute("mySetting",user);
		return "/page/user/userDetail";
	}
	@GetMapping("/myInfo/setting")
	public String myInfoSetting(HttpSession session, ModelMap model , RedirectAttributes rttr) {
		try {
			User user = (User)session.getAttribute("loginUser");
			model.addAttribute("userInfo", user);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("권한이 부족합니다");
			rttr.addAttribute("alertMessage","권한이 부족합니다");
			return "redirect:/Main";
		}
		return "/page/user/userSetting";
	}
	@GetMapping("/myInfo/brdList")
	public String myInfoBrdList(HttpSession session,HttpServletRequest request, ModelMap model , RedirectAttributes rttr) {
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		User user = (User)(session.getAttribute("loginUser"));
		List<Board> brdList = user.getBoardList();
	
		Collections.reverse(brdList);
		PagingDTO paging = new PagingDTO(page,user.getBoardList().size());
		int tempPG = (page - 1 )*paging.getCol_cnt();
		model.addAttribute("user", user);
		model.addAttribute("brdList",brdList.subList(tempPG, Math.min(tempPG+paging.getCol_cnt(), brdList.size() ) ));
		model.addAttribute("paging",paging);
		return "/page/user/userDetail_list";
	}
	
	@GetMapping("/@{name}")
	public String userInfo(@PathVariable("name") String name, ModelMap model, RedirectAttributes rttr) {
		model.addAttribute("userName", name);
		User user = userService.getByName(name);
		if(user.getInfoLock()==1) return infoLock(rttr);
		return "/page/user/userDetail";
	}
	
	@GetMapping("/@{name}/brdList")
	public String userInfo_list(@PathVariable("name") String name,HttpSession session,HttpServletRequest request, ModelMap model,RedirectAttributes rttr) {
		User user = userService.getByName(name);
		if(user.getInfoLock()==1) return infoLock(rttr);
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Board> brdList = user.getBoardList();
		Collections.reverse(brdList);
		PagingDTO paging = new PagingDTO(page,user.getBoardList().size());
		int tempPG = (page - 1 )*paging.getCol_cnt();
		model.addAttribute("user", user);
		model.addAttribute("brdList",brdList.subList(tempPG, Math.min(tempPG+paging.getCol_cnt(), brdList.size() ) ));
		model.addAttribute("paging",paging);
		return "/page/user/userDetail_list";
	}
	
	@PostMapping("/@{name}")
	public String userInfo(@PathVariable("name") String name,
			int infoLock, ModelMap model) {
		model.addAttribute("userName", name);
		User user = userService.getByName(name);
		user.setInfoLock(infoLock);
		userService.register(user);
		log.info("infoLock :{}",infoLock);
		return "/page/user/userDetail";
	}
	
	
	@GetMapping("/@{name}/setting")
	public String user_Setting(@PathVariable("name") String name ,HttpSession session ,ModelMap model,RedirectAttributes rttr) {
		try {
			User user = (User)session.getAttribute("loginUser");
			if(!user.getName().equals(name)&&!user.getGrade().equals("ADMIN")) throw new Exception();
			else if(user.getInfoLock()==1) infoLock(rttr);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("권한이 부족합니다");
			return "redirect:/Main";
		}
		model.addAttribute("userInfo", userService.getByName(name));
		return "/page/user/userSetting";
	}
	
	private String infoLock(RedirectAttributes rttr) {
		rttr.addAttribute("alertMSG","접근할 수 없는 사용자 입니다");
		return "redirect:/Main";
	}
	
}
