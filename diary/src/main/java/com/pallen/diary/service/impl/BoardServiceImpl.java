package com.pallen.diary.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pallen.diary.entity.board.Board;
import com.pallen.diary.entity.board.BoardRepository;
import com.pallen.diary.entity.board.Board_History;
import com.pallen.diary.entity.board.Board_HistoryRepository;
import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.BoardService;
import com.pallen.diary.util.PageUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Resource
	private BoardRepository boardRepository;
	
	@Resource
	private UserRepository userRepository;

	@Resource
	private Board_HistoryRepository board_HistoryRepository;
	
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
	public List<Board> list(int page, int col_cnt) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of((page-1), col_cnt,Sort.Direction.DESC,"bno");
		return PageUtil.pageToList(boardRepository.findAll(pageable));
	}
	@Override
	public List<Board> list(int page, int col_cnt, String keyword) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of((page-1), col_cnt,Sort.Direction.DESC,"bno");
		return PageUtil.pageToList(boardRepository.findbyTitleOrContentLike(keyword, pageable));
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
	@Override
	public List<Board> listByUser(User user,int page, int col_cnt) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of((page-1), col_cnt,Sort.Direction.DESC,"bno");
		return boardRepository.findByUser(user, pageable);
	}
	
	@Override
	public int countByUserAll(User user) {
		// TODO Auto-generated method stub
		return (int)boardRepository.countByUser(user);
	}

	

	@Override
	public void modify(Long bno, String title, String content,int board_kind) {
		// TODO Auto-generated method stub
		Board brd = boardRepository.findByBno(bno).get(0);
		Board_History history = new Board_History(brd);
		brd.setUpdate_date();
		brd.setBoard_kind(board_kind);
		brd.setTitle(title);
		brd.setContent(content);
		brd.setState("UPDATED");
		board_HistoryRepository.save(history);
		boardRepository.save(brd);
		
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return (int)boardRepository.count();
	}
	@Override
	public int countSearch(String keyword) {
		// TODO Auto-generated method stub
		return (int)boardRepository.countbyTitleOrContentLike(keyword);
	}

	@Override
	public List<Board_History> historyListAll(long bno) {
		// TODO Auto-generated method stub
		List<Board_History> rsList = board_HistoryRepository.findByBno(bno);
		Collections.reverse(rsList);
		return rsList;

	}
	
	@Override
	public List<Board_History> historyList(long bno,int page) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of((page-1), 5,Sort.Direction.DESC,"hbno");
		return board_HistoryRepository.findByBno(bno,pageable);
	}

	@Override
	public Board_History getHistoryOne(long hbno) {
		// TODO Auto-generated method stub
		return board_HistoryRepository.findByHbno(hbno).get(0);
	}

	@Override
	public void remove(long bno) {
		// TODO Auto-generated method stub
		Board brd = boardRepository.findByBno(bno).get(0);
		Board_History history = new Board_History(brd);
		history.setUpdateDate();
		history.setState("DELETED");
		board_HistoryRepository.save(history);
		boardRepository.delete(brd);
	}

	
	
	
}
