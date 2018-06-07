package com.bamboo.service;

import java.util.List;

import com.bamboo.entity.Category;
import com.bamboo.entity.CategoryVO;
import com.bamboo.entity.Product;

public interface ProductService {
	public List<Product> queryByLevelOne(int id);
	public List<CategoryVO> queryCategoryVO(List<Category> list);
	public List<Product> getProductByLevel(int level,int id,int page);
	public int getPages(int level,int id);
	public Product getProductById(int id);
}
