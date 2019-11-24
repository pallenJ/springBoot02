package com.example.bootweb.service.inf;

import java.util.List;

import com.example.bootweb.domain.BoardVO;
import com.example.bootweb.domain.Criteria;

public interface BoardService {
	
	public List<?> listAll();
	public List<?> list(Criteria cri);
	public int countAll();
	public BoardVO detail(int bno);
	public String register(BoardVO vo);
	public int remove(int bno);
	
	public List<?> historyList(int bno);
	
	public int removeAdmin(int bno);
	
	public int stateCnt(String state);
	public int stateCntInv(String state);
	public List<?> stateList(Criteria cri, String state);
	
}
