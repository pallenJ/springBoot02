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
import com.example.bootweb.domain.ReplyVO;
import com.example.bootweb.mapper.BoardMapper;
import com.example.bootweb.mapper.ReplyMapper;
import com.example.bootweb.service.inf.BoardService;
import com.example.bootweb.service.inf.ReplyService;
import com.example.bootweb.util.UserSHA256;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Bootweb0ApplicationTests {

	@Resource(name="replyService")
	ReplyService replyService;
	
	@Resource
	private ReplyMapper replyMapper;
	
	@Test
	public void contextLoads() {
		replyMapper.delete(2);
		//replyMapper.hisList(3).forEach(e->log.info(e.toString()));
	}

}
