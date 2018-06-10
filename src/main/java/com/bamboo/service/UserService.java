package com.bamboo.service;

import java.util.List;

import com.bamboo.entity.Address;
import com.bamboo.entity.User;

public interface UserService {
	public int register(User user);
	public User login(User user);
	public List<Address> getAddressById(int id);
}
