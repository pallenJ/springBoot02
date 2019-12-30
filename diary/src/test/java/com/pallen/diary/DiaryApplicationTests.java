package com.pallen.diary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pallen.diary.entity.User;
import com.pallen.diary.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DiaryApplicationTests {
	
	@Autowired
	UserRepository userRepository; 
	
	@Test
	void contextLoads() {
		
		//User user = User.builder().email("test@test.test").name("pallen").build();
		//log.info("user:{}",user.getCreateDate());
		
		
		//userRepository.save(user);
		userRepository.findAll().forEach(e -> log.info("user:{}",e));
		
	}

}
