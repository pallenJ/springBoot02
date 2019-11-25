package com.example.bootweb.mapper;

import java.util.List;

import com.example.bootweb.domain.ReplyVO;

public interface ReplyMapper {
	
	public void insert(ReplyVO vo);
	public ReplyVO detail(int rno); 
	public List<?> list(int bno); 
	public List<?> allList();
	public int delete(int rno);
	public void update(ReplyVO vo); 
}
