package com.huangzhipeng.shop.dao;

import java.util.List;

import com.huangzhipeng.shop.entity.Category;


public interface CategoryMapper {

	List<Category> selectAllCategories();

	Integer insertCategory(Category category);

	Integer updateCategory(Category category);

	Integer getChildCategoryCount(Integer id);

	Integer deleteCategoryById(Integer id);

}
