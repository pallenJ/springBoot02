package com.pallen.diary.service;

import java.util.List;

import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.user.User;

public interface BoardService {

	void add(Board brd);
	Board get(Long brd);
	List<Board>listAll();
	List<Board>list(int page);
	List<Board>listByEmail(String email);
	List<Board>listByUser(User user);
}
