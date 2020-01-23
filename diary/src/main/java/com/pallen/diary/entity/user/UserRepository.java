package com.pallen.diary.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.String;
import com.pallen.diary.entity.user.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	List<User> findByEmail(String email);
	default void deleteByEmail(String email) {
		delete(findByEmail(email).get(0));
		//deleteInBatch(findByEmail(email));
	}
	
}
