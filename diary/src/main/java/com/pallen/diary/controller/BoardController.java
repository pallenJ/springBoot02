package com.pallen.diary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pallen.diary.dto.PagingDTO;
import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.board.Board_History;
import com.pallen.diary.entity.user.User;
import com.pallen.diary.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@GetMapping("list")
	public String list(HttpServletRequest request ,HttpServletResponse response , ModelMap model) {
		int page = 1;
		try {
			log.info(request.getParameter("pg"));
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		PagingDTO paging = new PagingDTO(page,boardService.countAll());
		List<Board> brdList = new ArrayList<>();
		boardService.list(page, paging.getCol_cnt()).forEach(e -> brdList.add(e));
		//log.info("brd : {}",brdList);
		addCookie(response, "page", page+"");
		log.info("page:{}",page);
		
		model.addAttribute("paging", paging);
		model.addAttribute("brdList", brdList);
		
		return "/page/board/list";
	}
	
	@GetMapping(value = "/{bno}")
	public String detail(@PathVariable("bno")long bno,
			@CookieValue(value="page", required = false)Cookie pageCookie, ModelMap model) {
		Board brdDetail = boardService.get(bno); 
		model.addAttribute("brdDetail", brdDetail);
		model.addAttribute("pg", pageCookie.getValue());
		return "/page/board/detail";
	}
	@GetMapping(value = "/{bno}/history")
	public String history(HttpServletRequest request ,
			@PathVariable("bno")long bno, ModelMap model) {
		int page = 1;
		try {
			log.info(request.getParameter("pg"));
			page = Integer.parseInt(request.getParameter("pg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Board_History> hisList = boardService.historyList(bno, page);
		PagingDTO paging = new PagingDTO(page,5,5,boardService.historyListAll(bno).size());
		model.addAttribute("hisList", hisList);
		model.addAttribute("paging", paging);
		model.addAttribute("bno", bno);
		return "/page/board/edit_history_list";
	}
	@GetMapping(value = "/{bno}/history/{hbno}")
	public String historyDetail(@PathVariable("bno")long bno, @PathVariable("hbno")long hbno,ModelMap model) {
		Board_History brdHistory = boardService.getHistoryOne(hbno);
		model.addAttribute("brdDetail", brdHistory);
		return "/page/board/edit_history";
	}
	
	
	@GetMapping("/new")
	public String register() {
		
		return "/page/board/register";
	}
	
	@PostMapping("/add")
	public String register(HttpSession session,HttpServletRequest request,
			String title,String content) {//board_kind를 추가할걸 고려하고 만들것
		log.info("title:{}",title);
		log.info("content:{}",content);
		getIpAddress(request);
		try {
			Board brd = new Board(0, title, content, getIpAddress(request), (User)session.getAttribute("loginUser"));
			
			if(brd.getUser()==null) throw new Exception();
			log.info("user:{}",brd.getUser().getName());
			boardService.add(brd);
			
			return "redirect:/Main";
			
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/error";
		}
		
		
	}
	@GetMapping("/{bno}/edit")
	public String modify(HttpSession session,@PathVariable("bno")long bno,ModelMap model) {
		Board brdDetail = boardService.get(bno);
		String loginEmail = ((User)session.getAttribute("loginUser")).getEmail();
		if(!brdDetail.getUser().getEmail().equals(loginEmail)) {
			log.info("권한 부족");
			return "redirect:/error";
		}
		model.addAttribute("brdDetail",boardService.get(bno));
		return "page/board/modify";
		}
	
	@PostMapping("/modify")
	public String modify(HttpSession session,Board board) {
		long bno = board.getBno();
		board.setBoard_kind(0);//board_kind 추가후엔 주석처리
		String currectEmail = boardService.get(bno).getUser().getEmail();
		User sessionUser = ((User)session.getAttribute("loginUser"));
		if(sessionUser==null||!currectEmail.equals(sessionUser.getEmail())) {
			return "redirect:/error";
		}
			boardService.modify(bno, board.getTitle(), board.getContent(),board.getBoard_kind());
			return "redirect:/board/"+bno;
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
	
	private void addCookie(HttpServletResponse response,String name,String value) {
		addCookie(response, name, value,60*60*24);
	}
	private void addCookie(HttpServletResponse response,String name,String value,int maxAge) {
		Cookie setCookie = new Cookie(name, value);
		setCookie.setMaxAge(maxAge);
		response.addCookie(setCookie);
	}
	
	
	
}
