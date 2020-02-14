package com.pallen.diary.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.pallen.diary.service.api.KakaoAPI;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	@Autowired
	KakaoAPI kakaoAPI;
	
	@Resource
	private UserService userService;

	@Resource
	private BoardService boardService;
	
	@GetMapping("/Main")
	public String mainPage(HttpServletRequest request,ModelMap model) {
//		log.info(request.getParameter("pg")+"");
//		model.addAttribute("pg",request.getParameter("pg"));
		return "/page/main";
	}
	
	@GetMapping("{sns}_register")
	public String snsRegister(HttpServletRequest request, @PathVariable("sns")String regBy, ModelMap model) {
		if(snsRegisterAction(request, regBy)) {
			model.addAttribute("modal_message","이미 존재하거나 사용할 수 없는 계정 입니다.");
			return "index";
		}
		return "/page/user/sns_register";
	}
	
	private boolean snsRegisterAction(HttpServletRequest request,String regBy) {
		return false;
	}
	
	@GetMapping("{sns}_login")
	public String snsLogin(HttpSession session, HttpServletRequest request,
			@PathVariable("sns")String loginBy,ModelMap model) {
			snsLoginAction(session, request, loginBy,model);
			return "index";
	}
	
	private void snsLoginAction(HttpSession session, HttpServletRequest request,String loginBy,ModelMap model) {
		
		switch (loginBy) {
		case "kakao":
			String code = (String) request.getParameter("code");
			log.info("kakao code : {}",code);
			String access_Token = kakaoAPI.getAccessToken(code,"login");
			Map<String, Object> userInfo = kakaoAPI.getUserInfo(access_Token);
			log.info("login Controller : {}", userInfo);
			
			// 클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
			if (userInfo.get("email") != null) {
				String email = (String)userInfo.get("email");
				try {
					User loginUser = userService.get(email);
					if(!loginUser.getSns_reg().equals(loginBy.toUpperCase())) throw new Exception();
					session.setAttribute("loginUser", loginUser);
					session.setAttribute("access_Token", access_Token);
					session.setAttribute("loginBy", loginBy);
					log.info("email : {}",userInfo.get("email").toString());
				} catch (Exception e) {
					// TODO: handle exception
					log.info("해당경로로 가입하지 않은 계정");
					model.addAttribute("modal_message","해당경로로 가입하지 않은 계정입니다.");
				}//가입한 계정이 아닐경우 처리
			}

			break;

		default:
			break;
		}
		
	}
	
}
