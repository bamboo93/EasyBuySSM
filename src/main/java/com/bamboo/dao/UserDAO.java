package com.bamboo.dao;

import java.util.List;

import com.bamboo.entity.Address;
import com.bamboo.entity.User;

public interface UserDAO {
	public int register(User user);
	public User login(User user);
	public List<Address> getAddressById(int id);
}
