package com.bamboo.service;

import java.util.List;

import com.bamboo.entity.Category;

public interface CategoryService {
	public List<Category> queryAll();
	public List<Category> queryLevelTwoByLevelOne(int id);
}
