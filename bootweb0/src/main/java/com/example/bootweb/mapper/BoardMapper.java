package com.example.bootweb.mapper;

import java.util.List;

import com.example.bootweb.domain.BoardVO;
import com.example.bootweb.domain.Criteria;

public interface BoardMapper {

	public void insert(BoardVO vo);
	public BoardVO select(int bno);
	public List<?> listAll();
	public List<?> listState();
	public List<?> listWithPaging(Criteria cri);	
	public int countAll();
	public void update(BoardVO vo);
	public int pageNum(int bno, int amt);
	public int delete(int bno);
	
	public void insertHistory(int bno);
	
	
	public List<?> getBoardHistory(int bno);
	public void updatehisDel(int bno);
	
	public int stateCntInv(String state);
	public int stateCnt(String state);
	public List<?> stateList(Criteria cri);
 }
