package com.pallen.diary.entity.board;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.Long;
import com.pallen.diary.entity.board.Board_History;

public interface Board_HistoryRepository extends JpaRepository<Board_History, Long>{
	List<Board_History> findByBno(Long bno);
	List<Board_History> findByBno(Long bno,Sort sort);
}
