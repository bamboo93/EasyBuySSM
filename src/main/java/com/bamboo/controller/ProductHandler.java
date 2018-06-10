package com.bamboo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

@Controller
public class ProductHandler {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@RequestMapping("/productList")
	public ModelAndView productList(@RequestParam("level")int level,@RequestParam("id")int id,@RequestParam("page")int page){
		List<Product> productList=productService.getProductByLevel(level, id,page);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("productList");
		mav.addObject("productList",productList);
		List<Category> categoryList=categoryService.queryAll();
		mav.addObject("categoryList",categoryList);
		int pages=productService.getPages(level, id);
		mav.addObject("pages", pages);
		mav.addObject("page", page);
		mav.addObject("level", level);
		mav.addObject("id", id);
		return mav;
		
	}
	@RequestMapping("/getProductById")
	public ModelAndView getProductById(@RequestParam("id")int id){
		Product product=productService.getProductById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("product", product);
		mav.setViewName("productDeatil");
		return mav;
		
	}
	@RequestMapping("/addCar")
	public ModelAndView addCar(@RequestParam("productId")int productId,@RequestParam("quantity")int quantity){
		ModelAndView mav=new ModelAndView();
		Product product=productService.getProductById(productId);
		mav.addObject("product", product);
		mav.addObject("quantity", quantity);
		mav.setViewName("toSettlement");
		return mav;
	}
	
	@RequestMapping("/createOrders")
	public ModelAndView createOrders(HttpSession session,@RequestParam("address")String address,@RequestParam("cost")double cost){
		try {
			address=new String(address.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user =(User) session.getAttribute("user2");
		int id=user.getId();
		String loginName=user.getLoginName();
		Date date=new Date();
		//随机生成一列字符串
		StringBuffer buff=new StringBuffer();
		for(int i=0;i<3;i++){
			buff.append(Integer.toHexString(new Random().nextInt()));
		}
		String serialNumber=buff.toString().toUpperCase();
		productService.createOrder(id, loginName, address, date, cost, serialNumber);
		ModelAndView mav=new ModelAndView();
		mav.addObject("cost", cost);
		mav.addObject("address", address);
		mav.setViewName("settlement3");
		mav.addObject("serialNumber", serialNumber);
		return mav;
	}
}
