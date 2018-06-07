package com.bamboo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bamboo.dao.CategoryDAO;
import com.bamboo.entity.Category;
import com.bamboo.entity.CategoryVO;
import com.bamboo.entity.Product;
import com.bamboo.entity.User;
import com.bamboo.service.CategoryService;
import com.bamboo.service.ProductService;
import com.bamboo.service.UserService;

@Controller
public class UserHandler {
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@RequestMapping("/easybuy_register")
	public String register(User user){
		userService.register(user);
		return "login";
	}
	
	@RequestMapping("/easybuy_login")
	public ModelAndView login(User user){
		ModelAndView mav=new ModelAndView();
		User user2=userService.login(user);
		if(user2!=null){
			//获取模型数据
			//获取type为1,2,3的商品
			//为3中商品分类建立级联关系
			List<Category> list=categoryService.queryAll();
			mav.setViewName("main");
			mav.addObject("list",list);
			mav.addObject("categoryVOList",productService.queryCategoryVO(list));
		}else{
			mav.setViewName("login");
		}
		return mav;
	}
}
