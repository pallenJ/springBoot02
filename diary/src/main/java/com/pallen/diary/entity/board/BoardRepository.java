package com.pallen.diary.entity.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.board.Board;
import java.util.List;


import java.lang.Long;

public interface BoardRepository extends JpaRepository<Board, Long>{
	List<Board> findByUser(User user);
	List<Board> findByBno(Long bno);

	Page<Board> findAll(Pageable pageable);
	
	@Query(value = "SELECT B FROM Board B WHERE B.state != ?1")
	Page<Board> findByStateNot(@Param("state") String state,Pageable pageable);

	
}
