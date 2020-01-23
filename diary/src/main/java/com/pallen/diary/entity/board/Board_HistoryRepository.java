package com.pallen.diary.entity.board;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.Long;
import com.pallen.diary.entity.board.Board_History;

@Repository
public interface Board_HistoryRepository extends JpaRepository<Board_History, Long>{
	List<Board_History> findByHbno(Long hbno);
	List<Board_History> findByBno(Long bno);
	List<Board_History> findByBno(Long bno,Pageable pagable);
}
