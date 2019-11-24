package com.example.bootweb;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bootweb.domain.BoardVO;
import com.example.bootweb.domain.Criteria;
import com.example.bootweb.mapper.BoardMapper;
import com.example.bootweb.service.inf.BoardService;
import com.example.bootweb.util.UserSHA256;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Bootweb0ApplicationTests {

	@Resource(name="boardService")
	BoardService boardService;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void contextLoads() {
		log.info("1:{}",UserSHA256.encrypt(""));
		//log.info(boardMapper.pageNum(9,10)+"");
		//boardMapper.insert(new BoardVO("ttt", "www", "ccc"));
		//int max = boardService.listAll().size();
		
		//boardMapper.listWithPaging(new Criteria(2, 10, max)).forEach(e->log.info(e.toString()));
	}

}
