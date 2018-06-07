package com.bamboo.dao;

import java.util.List;

import com.bamboo.entity.Category;

public interface CategoryDAO {
	public List<Category> queryByTypeAndParentId(int type,int parentId);
	public List<Category> queryLevelTwoByLevelOne(int id);
}
