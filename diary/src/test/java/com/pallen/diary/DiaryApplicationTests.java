package com.pallen.diary;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.pallen.diary.entity.board.BoardRepository;
import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.BoardService;
import com.pallen.diary.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DiaryApplicationTests {
	
	@Resource
	UserRepository userRepository; 
	
	@Resource
	UserService userService;
	
	@Resource
	BoardRepository boardRepository;
	
	@Resource
	BoardService boardService;
	
	@Test
	void contextLoads() {
		
		//User user = User.builder().email("test@test.test").name("pallen").build();
		//log.info("user:{}",user.getCreateDate());
		try {
			//log.info("board:{}",boardRepository.count());
			//User user = userRepository.findByEmail("vhxj1@naver.com").get(0);
			//boardRepository.findByUser(user).forEach(e->log.info("board : {}",e));
			//userRepository.deleteById("abc@abc.abc");
//			Pageable pageble = PageRequest.of(2, 1);
//			boardRepository.findAll(pageble).forEach(e->log.info("brd:{}",e));
//			boardService.list(1, 10).forEach(e->log.info("brd:{}",e));
			log.info("brds :{}",boardService.list(1, 10));
			
		} catch (Exception e) {
			log.info("not found");
		}
		
		
		//userRepository.save(user);
		//userRepository.findAll().forEach(e -> log.info("user:{}",e));
	
	}

}
