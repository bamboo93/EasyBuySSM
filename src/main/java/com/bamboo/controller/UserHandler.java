package com.bamboo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;






import com.bamboo.entity.Address;
import com.bamboo.entity.Category;
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
	public ModelAndView login(User user,HttpSession session){
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
			//登录成功以后将用户存进Session中
			session.setAttribute("user2", user2);
			
		}else{
			mav.setViewName("login");
		}
		return mav;
	}
	@RequestMapping("/isLogin")
	public ModelAndView isLogin(HttpSession session,@RequestParam("fileName")String fileName,@RequestParam("name")String productName,@RequestParam("price")double price,@RequestParam("quantity")int quantity){
		//get方式传入的name,不支持post方式，需要进行字符格式
		try {
			productName=new String (productName.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav=new ModelAndView();
		User user=(User) session.getAttribute("user2");
		if(user.getLoginName()!=null){
			//通过用户id获取用户地址
			List<Address>  addresses=userService.getAddressById(user.getId());
			Product product=new Product();
			product.setFileName(fileName);
			product.setName(productName);
			product.setPrice(price);
			mav.addObject("product", product);
			mav.addObject("quantity", quantity);
			mav.addObject("addresses", addresses);
			mav.setViewName("settlement2"); 
			
		}else{
			mav.setViewName("login"); 
		}
		
		return mav;
	}
}
