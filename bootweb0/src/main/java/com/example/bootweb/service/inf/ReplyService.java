package com.example.bootweb.service.inf;

import java.util.List;

import com.example.bootweb.domain.ReplyVO;

public interface ReplyService {
	public String register(ReplyVO vo);
	public List<?> list(int bno);
	public List<?> allList();
	public int remove(int rno);
	public List<?> historyReply(int rno);
}
