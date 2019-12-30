package com.pallen.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pallen.diary.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
