package com.pallen.diary.service;

import com.pallen.diary.entity.User;

public interface UserService {

	void register(User user);
	User  get(String email);
}
