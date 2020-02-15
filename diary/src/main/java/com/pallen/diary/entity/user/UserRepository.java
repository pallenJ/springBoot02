package com.pallen.diary.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	List<User> findByName(String name);
	
	@Query("SELECT COUNT(*) FROM User U WHERE U.email = ?1")
	long countByEmail(@Param("email")String email);
	
	
	@Query("SELECT U FROM User U WHERE U.email = ?1 or U.name = ?2")
	List<User> findByEmailOrName(@Param("email")String email,@Param("name")String name);
	@Query("SELECT COUNT(*) FROM User U WHERE U.email = ?1 or U.name = ?2")
	long countByEmailOrName(String email,String name);
}
