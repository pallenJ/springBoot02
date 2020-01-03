package com.pallen.diary.entity.board;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.board.Board;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>{
	List<Board> findByUser(User user);

}
