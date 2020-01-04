package com.pallen.diary;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pallen.diary.entity.board.BoardRepository;
import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
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
	
	@Test
	void contextLoads() {
		
		//User user = User.builder().email("test@test.test").name("pallen").build();
		//log.info("user:{}",user.getCreateDate());
		try {
			//log.info("board:{}",boardRepository.count());
			//User user = userRepository.findByEmail("vhxj1@naver.com").get(0);
			//boardRepository.findByUser(user).forEach(e->log.info("board : {}",e));
			userRepository.deleteById("abc@abc.abc");
		} catch (Exception e) {
			log.info("not found");
		}
		
		
		//userRepository.save(user);
		//userRepository.findAll().forEach(e -> log.info("user:{}",e));
	
	}

}
