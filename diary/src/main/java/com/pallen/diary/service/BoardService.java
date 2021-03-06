package com.pallen.diary.service;

import java.util.List;


import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.board.Board_History;
import com.pallen.diary.entity.user.User;

public interface BoardService {

	void add(Board brd);
	Board get(Long bno);
	int countAll();
//	int countBY();
	List<Board>listAll();
	List<Board>list(int page, int amount);
	List<Board>listByEmail(String email);
	List<Board>listByUser(User user);
	List<Board> listByUser(User user, int page, int col_cnt);
	
	void modify(Long bno, String title , String content, int board_kind);
	
	List<Board_History> historyListAll(long bno);
	List<Board_History> historyList(long bno,int page);
	Board_History getHistoryOne(long hbno);
	
	void remove(long bno);
	List<Board> list(int page, int col_cnt, String keyword);
	
	int countSearch(String keyword);
	int countByUserAll(User user);
	
}
