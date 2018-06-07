package com.bamboo.dao;

import com.bamboo.entity.User;

public interface UserDAO {
	public int register(User user);
	public User login(User user);
}
