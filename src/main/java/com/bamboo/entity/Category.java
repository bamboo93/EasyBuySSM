package com.bamboo.entity;

import java.util.List;

/**
 * 商品分类实体类
 * @author Administrator
 *
 */
public class Category {
	private int id;
	private String name;
	private int type;
	private List<Category> category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", type=" + type
				+ ", category=" + category + "]";
	}
	
	
}
