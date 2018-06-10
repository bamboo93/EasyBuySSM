package com.bamboo.dao;

import java.util.Date;
import java.util.List;

import com.bamboo.entity.Product;

public interface ProductDAO {
	public List<Product> queryByLevelOne(int id);
	public List<Product> queryByLevelTwo(int id,int start,int length);
	public List<Product> queryByLevelThree(int id,int start,int length);
	public int getPagesByLevelTwo(int id);
	public int getPagesByLevelThree(int id);
	public Product getProductById(int id);
	public int createOrder(int userId, String loginName, String address,Date date, double cost, String serialNumber);
}
