package com.bamboo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboo.dao.CategoryDAO;
import com.bamboo.dao.ProductDAO;
import com.bamboo.entity.Category;
import com.bamboo.entity.CategoryVO;
import com.bamboo.entity.Product;
import com.bamboo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	
	private int datePrePage=4;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Override
	public List<Product> queryByLevelOne(int id) {
		return productDAO.queryByLevelOne(id);
	}
	@Override
	public List<CategoryVO> queryCategoryVO(List<Category> list) {
		List<CategoryVO> result=new ArrayList<CategoryVO>();
		for (Category category : list) {
			if(category.getType()==1){
				CategoryVO categoryVO=new CategoryVO();
				categoryVO.setProducts(queryByLevelOne(category.getId()));
				//获取一级分类对应的二级分类
				categoryVO.setCategorys(categoryDAO.queryLevelTwoByLevelOne(category.getId()));
				//获取一级分类的名称
				categoryVO.setName(category.getName());
				result.add(categoryVO);
			}
		}
		
		return result;
	}
	@Override
	public List<Product> getProductByLevel(int level, int id,int page) {
		int start=(page-1)*datePrePage;
		if(level==2){
			return productDAO.queryByLevelTwo(id,start,datePrePage);
		}
		if(level==3){
			return productDAO.queryByLevelThree(id,start,datePrePage);
		}
		return productDAO.queryByLevelOne(id);
	}
	@Override
	public int getPages(int level, int id) {
		int counts=0;
		if(level==2){
			counts= productDAO.getPagesByLevelTwo(id);
		}
		if(level==3){
			counts= productDAO.getPagesByLevelThree(id);
		}
		int pages=0;
		if(counts%datePrePage==0){
			pages=counts/datePrePage;
		}else{
			pages=counts/datePrePage +1;
		}
		return pages;
	}
	@Override
	public Product getProductById(int id) {
		
		return productDAO.getProductById(id);
	}

}
