package com.example.bootweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootweb.domain.BoardVO;
import com.example.bootweb.domain.Criteria;
import com.example.bootweb.mapper.BoardMapper;
import com.example.bootweb.service.inf.BoardService;
import com.example.bootweb.util.UserSHA256;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource
	private BoardMapper boardMapper;

	@Override
	public List<?> listAll() {
		return boardMapper.listAll();
	}

	@Override
	public List<?> list(Criteria cri) {
		return boardMapper.listWithPaging(cri);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return boardMapper.countAll();
	}

	@Override
	public BoardVO detail(int bno) {
		return boardMapper.select(bno);
	}

	@Override
	public String register(BoardVO vo) {
		// TODO Auto-generated method stub
		if(vo.getBno()==0) {
		vo.setPassword(UserSHA256.encrypt(vo.getPassword()));	
		boardMapper.insert(vo);
		return "/board/list";
		}
		else {
		boardMapper.insertHistory(vo.getBno());
		boardMapper.update(vo);	 
		return "/board/"+vo.getBno();
		}
	}
 
	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		try {
			int pageNum = boardMapper.pageNum(bno,10);
			boardMapper.insertHistory(bno);
			boardMapper.updatehisDel(bno);
			return pageNum;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}	
		
	}
	
	@Override
	public int removeAdmin(int bno) {
		// TODO Auto-generated method stub
		try {
			  int pageNum = boardMapper.pageNum(bno,10);
			  BoardVO vo = boardMapper.select(bno); 
			  if(boardMapper.delete(bno)==0) throw
			  new Exception(); boardMapper.insertHistory(vo.getBno());
			return pageNum;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}	
		
	}

	@Override
	public List<?> historyList(int bno) {
		// TODO Auto-generated method stub
		return boardMapper.getBoardHistory(bno);
	}

	@Override
	public List<?> stateList(Criteria cri, String state) {
		// TODO Auto-generated method stub
		cri.setState(state);
		return boardMapper.stateList(cri);
	}

	@Override
	public int stateCnt(String state) {
		// TODO Auto-generated method stub
		return boardMapper.stateCnt(state);
	}

	@Override
	public int stateCntInv(String state) {
		// TODO Auto-generated method stub
		return boardMapper.stateCntInv(state);
	}

	
}
