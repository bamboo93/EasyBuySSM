package com.bamboo.service;

import com.bamboo.entity.User;

public interface UserService {
	public int register(User user);
	public User login(User user);
}
