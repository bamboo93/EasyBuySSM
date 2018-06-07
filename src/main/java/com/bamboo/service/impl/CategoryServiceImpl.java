package com.bamboo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboo.dao.CategoryDAO;
import com.bamboo.entity.Category;
import com.bamboo.service.CategoryService;
@Service
public class CategoryServiceImpl  implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;
	@Override
	public List<Category> queryAll() {
		
		List<Category> list1=categoryDAO.queryByTypeAndParentId(1,0);
		//建立3种商品的级联关系
		for (Category category : list1) {
			List<Category> list2=categoryDAO.queryByTypeAndParentId(2, category.getId());
			for (Category category2 : list2) {
				List<Category> list3=categoryDAO.queryByTypeAndParentId(3, category2.getId());
				category2.setCategory(list3);
			}
			category.setCategory(list2);
		}
		
		return list1;
	}
	@Override
	public List<Category> queryLevelTwoByLevelOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
