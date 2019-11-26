package com.huangzhipeng.shop.service;

import java.util.List;
import java.util.Map;

import com.huangzhipeng.shop.entity.Category;


public interface CategoryService {

	List<Category> getAllCategories();

	Integer addCategory(Category category);

	Map<String, String> deleteCategory(Integer id);

}
