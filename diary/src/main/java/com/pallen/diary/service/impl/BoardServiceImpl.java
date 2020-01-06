package com.pallen.diary.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.board.BoardRepository;
import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Resource
	private BoardRepository boardRepository;
	
	@Resource
	private UserRepository userRepository;

	
	@Override
	public void add(Board brd) {
		boardRepository.save(brd);
	}

	@Override
	public Board get(Long bno) {
		// TODO Auto-generated method stub
		return boardRepository.findByBno(bno).get(0);
	}

	@Override
	public List<Board> listAll() {
		// TODO Auto-generated method stub
		return boardRepository.findAll();
	}

	@Override
	public List<Board> list(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> listByEmail(String email) {
		// TODO Auto-generated method stub
		return listByUser(userRepository.findByEmail(email).get(0));
	}

	@Override
	public List<Board> listByUser(User user) {
		// TODO Auto-generated method stub
		return boardRepository.findByUser(user);
	}

}
