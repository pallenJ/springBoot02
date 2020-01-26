package com.pallen.diary.entity.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.board.Board;
import java.util.List;


import java.lang.Long;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	List<Board> findByUser(User user);
	List<Board> findByBno(Long bno);

	Page<Board> findAll(Pageable pageable);
	
	@Query(value = "SELECT B FROM Board B WHERE B.state != ?1")
	Page<Board> findByStateNot(@Param("state") String state,Pageable pageable);
	
	@Query("SELECT B FROM Board B WHERE B.title like %:keyword% or B.content like %:keyword%")
	Page<Board> findbyTitleOrContentLike(@Param("keyword") String keyword,Pageable pageable);
	
	@Query("SELECT COUNT(*) FROM Board B WHERE B.title like %:keyword% or B.content like %:keyword%")
	long countbyTitleOrContentLike(@Param("keyword") String keyword);
	
//	default void deleteByBno(long bno) {
//		delete(findByBno(bno).get(0));
//	}
	
	
}
