package com.pallen.diary.service;

import java.util.List;

import com.pallen.diary.entity.user.User;

public interface AdminService {
	public List<User> userListAll();
	public List<User> userList(int page);
}
