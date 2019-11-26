package com.example.bootweb.mapper;

import java.util.List;

import com.example.bootweb.domain.ReplyVO;

public interface ReplyMapper {
	
	public void insert(ReplyVO vo);
	public void update(ReplyVO vo); 
	public void hisInsert(int rno);
	
	public ReplyVO detail(int rno);
	
	public List<?> list(int bno); 
	public List<?> allList();
	public List<?> hisList(int rno);
	
	public int delete(int rno);
	public int updateDel(int rno);
	
	
}
