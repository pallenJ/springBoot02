package com.pallen.diary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.board.BoardRepository;
import com.pallen.diary.entity.board.Board_History;
import com.pallen.diary.entity.board.Board_HistoryRepository;
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
	
	@Resource
	Board_HistoryRepository board_historyRepository;
	@Test
	void stringUtilTest() {
		String rdpw = RandomStringUtils.randomAlphanumeric(8, 14);
		log.info("random pw:{}", rdpw);
		log.info("random len:{}", rdpw.length());
	}
	//@Test
	void userTest() {
		/*
		 * long temp = userRepository.countByEmailOrName("vhxj1@naver.com", "준모");
		 * log.info("cnt:{}",temp);
		 */
		
		User user = userRepository.findByName("pallen").get(0);
		log.info(user.toString());
		//boardService.listByUser(user,1,3).forEach(e->log.info(e.toString()));
		
	}
	
	//@Test
	void updateBrd() {
		/*
		 * Board brd = boardRepository.findByBno(300L).get(0); brd.setUpdate_date();
		 * boardRepository.save(brd);
		 */
		/*
		 * long bno = 319L; String title = "test22"; String content =
		 * "<h1>modify test2</h1>"; boardService.modify(bno, title, content,0);
		 */
		//boardService.historyList(319L).forEach(e->log.info("{}",e));
	}
	
	//@Test
	void deleteTest() {
		boardService.remove(112L);
	}
	
	//@Test
	void searchTest() {
		/*
		 * Pageable pageable = PageRequest.of(0, 10,Sort.Direction.DESC,"bno");
		 * boardRepository.findbyTitleOrContentLike("bizzare",pageable).forEach(e ->
		 * log.info(e.toString()));
		 */
		//boardService.list(1, 10, "jo").forEach(e -> log.info("jo:{}",e));
		log.info(boardRepository.countbyTitleOrContentLike("test")+"");
		
	}
	
	//@Test
	void cntTest() {
		log.info("cnt:{}", boardService.countAll());
	}
	//@Test
	void contextLoads() {

		List<User> users = userRepository.findAll();
		Set<Board> brds = new HashSet<>();

		// User user = User.builder().email("test@test.test").name("pallen").build();
		// log.info("user:{}",user.getCreateDate());
		try {
			/*
			 * log.info("board:{}",boardRepository.count()); User user =
			 * userRepository.findByEmail("vhxj1@naver.com").get(0);
			 * boardRepository.findByUser(user).forEach(e->log.info("board : {}",e));
			 * userRepository.deleteById("abc@abc.abc"); Pageable pageble =
			 * PageRequest.of(2, 1);
			 * boardRepository.findAll(pageble).forEach(e->log.info("brd:{}",e));
			 * boardService.list(1, 10).forEach(e->log.info("brd:{}",e));
			 */
			//log.info("brds :{}",boardService.list(1, 10));
			String[] titles = { "title", "TITLE", "TEST", "test", "jojo", "JOJO" };
			String[] contents = { "content", "CONTENT", "TESTTEST", "testtest", "'s bizzare adventure","'S BIZZARE ADVENTURE" };

			int cnt = 2;
			Random random = new Random();
			while (cnt-- > 0) {
				int unum = random.nextInt(3);
				int bnum = random.nextInt(6);
				User usertmp = users.get(unum);
				Board nb = new Board(0, titles[bnum], contents[bnum], "127.0.0.1", usertmp);
				brds.add(nb);
			}
			log.info("insert complete");

		} catch (Exception e) {
			log.info("not found");
		}

		boardRepository.saveAll(brds);
		log.info("save complete");
		long time = System.currentTimeMillis(); 

		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String str = dayTime.format(new Date(time));
		
		log.info(str);
		


		// userRepository.save(user);
		// userRepository.findAll().forEach(e -> log.info("user:{}",e));

	}
	
	
	
	
}
