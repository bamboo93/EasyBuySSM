package com.bamboo.dao;

import java.util.List;

import com.bamboo.entity.Product;

public interface ProductDAO {
	public List<Product> queryByLevelOne(int id);
	public List<Product> queryByLevelTwo(int id,int start,int length);
	public List<Product> queryByLevelThree(int id,int start,int length);
	public int getPagesByLevelTwo(int id);
	public int getPagesByLevelThree(int id);
	public Product getProductById(int id);
}
