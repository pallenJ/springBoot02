package com.pallen.diary.service;

import com.pallen.diary.entity.user.User;

public interface UserService {

	void register(User user);
	User  get(String email);
}
