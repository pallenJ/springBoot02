package com.example.bootweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.bootweb.domain.ReplyVO;
import com.example.bootweb.mapper.ReplyMapper;
import com.example.bootweb.service.inf.ReplyService;
import com.example.bootweb.util.UserSHA256;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{
	
	@Resource
	private ReplyMapper replyMapper;
	
	@Override
	public String register(ReplyVO vo) {
		// TODO Auto-generated method stub
		if(vo.getRno() == 0 ) {
			vo.setPassword(UserSHA256.encrypt(vo.getPassword()));
			replyMapper.insert(vo);
			return "register";
		}else {
			return "modify";
		}
	}

	@Override
	public List<?> list(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> allList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int rno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> historyReply(int rno) {
		// TODO Auto-generated method stub
		return null;
	}

}
