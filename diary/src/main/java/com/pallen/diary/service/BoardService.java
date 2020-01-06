package com.pallen.diary.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.user.User;

public interface BoardService {

	void add(Board brd);
	Board get(Long brd);
	List<Board>listAll();
	Page<Board>list(int page, int amount);
	List<Board>listByEmail(String email);
	List<Board>listByUser(User user);
}
