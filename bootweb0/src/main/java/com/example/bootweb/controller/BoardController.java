package com.example.bootweb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bootweb.domain.BoardVO;
import com.example.bootweb.domain.Criteria;
import com.example.bootweb.domain.PagingView;
import com.example.bootweb.service.inf.BoardService;
import com.example.bootweb.util.UserSHA256;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	/*
	 * @Autowired
	 * 
	 * @Qualifier("boardService")
	 */
	@Resource
	private BoardService boardService;
	
	@GetMapping("list")
	public void list(HttpServletRequest request,Model model) {
	log.info("ip :{}",getIpAdress(request));
	int pageNum = 1;
	int amount = 10;
	int max = boardService.stateCntInv("DELETED");
	log.info("max:"+max);
	try {
		pageNum = Integer.parseInt(request.getParameter("p"));
		amount = Integer.parseInt(request.getParameter("amt"));
	} catch (Exception e) {}
	Criteria cri = new Criteria(pageNum, amount, max);
	List<?> list = 	boardService.list(cri);
	log.info(cri.toString());	
	log.info(new PagingView(cri).toString());	
	model.addAttribute("list", list);
	model.addAttribute("paging", new PagingView(cri));
	model.addAttribute("amount",amount);
	}
	
	@GetMapping(value = "/{bno}")
	public String detail(@PathVariable("bno")int bno, Model model) {
		BoardVO vo = boardService.detail(bno);
		vo.setPassword("");
		model.addAttribute("bno", bno);
		model.addAttribute("board", vo);
		//model.addAttribute("editHistory", boardService.historyList(bno));
		
		log.info("vo = "+vo);
		//log.info("edit = "+boardService.historyList(bno));
		
		return "board/detail";
	}
	
	@GetMapping("editHistoryForm")
	public String getEditHistory(int bno, Model model){
		List<?> history  =  boardService.historyList(bno);
		model.addAttribute("editHistory", history);
		log.info(history.toString());
		return "/board/detail_history";
	}
	
	
	@GetMapping(value = "/register")
	public void register() {}
	
	@PostMapping(value = "/register")
	public String register(HttpServletRequest request,BoardVO vo , Model model) {
		vo.setIp_address(getIpAdress(request));
		log.info(vo.toString());
		String rdrURL = boardService.register(vo);
		return "redirect:"+rdrURL;
	}
	
	  @GetMapping(value = "/remove") 
	  public String remove(RedirectAttributes rttr, int bno,Model model) { 
		  int p = boardService.remove(bno);
		  log.info("page:"+p);
		  rttr.addAttribute("p",p);
		  rttr.addAttribute("amt",10);
		  
		  return "redirect:/board/list";
	}
	
	@ResponseBody  
	@PostMapping("pwCheck")  
	public boolean pwCheck(int bno,String pw) {
		BoardVO vo = boardService.detail(bno);
		
		return UserSHA256.encrypt(pw).equals(vo.getPassword());
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
