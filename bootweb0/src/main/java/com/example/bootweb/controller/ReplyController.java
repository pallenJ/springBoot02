package com.example.bootweb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import com.example.bootweb.domain.ReplyVO;
import com.example.bootweb.service.inf.ReplyService;
import com.example.bootweb.util.UserSHA256;


@Slf4j
@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Resource(name="replyService")
	ReplyService replyService;
	
	@PostMapping("register")
	@ResponseBody
	public String register(ReplyVO vo) {
		log.info("vo : "+vo.toString());
		return replyService.register(vo);
	}
	
	@ResponseBody
	@PostMapping("pwCheck")
	public boolean pwCheck(int rno , String pw) {
		ReplyVO vo = replyService.detail(rno);
		log.info("insert :{}",UserSHA256.encrypt(pw));
		return UserSHA256.encrypt(pw).equals(vo.getPassword());
	}
	
}
