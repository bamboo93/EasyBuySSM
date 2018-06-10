package com.bamboo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboo.dao.UserDAO;
import com.bamboo.entity.Address;
import com.bamboo.entity.User;
import com.bamboo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public int register(User user) {
		
		return userDAO.register(user);
	}

	
	public 	User login(User user) {
		
		return userDAO.login(user);
	}


	@Override
	public List<Address> getAddressById(int id) {
		
		return userDAO.getAddressById(id);
	}
	
}
