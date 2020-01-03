package com.pallen.diary;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DiaryApplicationTests {
	
	@Autowired
	UserRepository userRepository; 
	
	@Resource
	UserService userService;
	
	@Test
	void contextLoads() {
		
		//User user = User.builder().email("test@test.test").name("pallen").build();
		//log.info("user:{}",user.getCreateDate());
		try {
			log.info("user:{}",userService.get("sdfasdf"));
			
		} catch (Exception e) {
			log.info("not found");
		}
		
		
		//userRepository.save(user);
		//userRepository.findAll().forEach(e -> log.info("user:{}",e));
	
	}

}
