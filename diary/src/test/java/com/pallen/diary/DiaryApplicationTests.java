package com.pallen.diary;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.pallen.diary.entity.board.Board;
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
		
		List<User> users = userRepository.findAll();
		Set<Board> brds  = new HashSet<>();
		
		//User user = User.builder().email("test@test.test").name("pallen").build();
		//log.info("user:{}",user.getCreateDate());
		long a=5;
		try {
			//log.info("board:{}",boardRepository.count());
			//User user = userRepository.findByEmail("vhxj1@naver.com").get(0);
			//boardRepository.findByUser(user).forEach(e->log.info("board : {}",e));
			//userRepository.deleteById("abc@abc.abc");
//			Pageable pageble = PageRequest.of(2, 1);
//			boardRepository.findAll(pageble).forEach(e->log.info("brd:{}",e));
//			boardService.list(1, 10).forEach(e->log.info("brd:{}",e));
//			log.info("brds :{}",boardService.list(1, 10));
			String [] titles = {"title","TITLE","TEST","test" ,"jojo","JOJO"};
			String [] contents = {"content","CONTENT","TESTTEST","testtest","'s bizzare adventure","'S BIZZARE ADVENTURE"};
			
			
			  int cnt = 100; Random random = new Random(); while(cnt-->0) { int unum =
			  random.nextInt(3); int bnum = random.nextInt(6); User usertmp =
			  users.get(unum); Board nb = new Board(0, titles[bnum], contents[bnum],
			   "127.0.0.1", usertmp); brds.add(nb); }
			  log.info("insert complete");
			 			
		} catch (Exception e) {
			log.info("not found");
		}
		//boardRepository.save(new Board(null, 0, "aaa", "bbb", null, null, null, users.get(0)));
		boardRepository.saveAll(brds);
		log.info("save complete");
		
		
		//userRepository.save(user);
		//userRepository.findAll().forEach(e -> log.info("user:{}",e));
	
	}

}
