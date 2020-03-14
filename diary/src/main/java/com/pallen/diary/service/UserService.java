package com.pallen.diary.service;

import java.util.List;
import java.util.Map;

import com.pallen.diary.entity.user.User;

public interface UserService {

	void register(User user);
	
	User  get(String email);
	User getByName(String name);
	boolean exist(String email, String name);
	boolean exist(String email);
	
	
}
