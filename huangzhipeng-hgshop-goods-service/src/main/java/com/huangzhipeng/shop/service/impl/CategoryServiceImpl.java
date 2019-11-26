package com.huangzhipeng.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.huangzhipeng.shop.dao.CategoryMapper;
import com.huangzhipeng.shop.entity.Category;
import com.huangzhipeng.shop.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryMapper.selectAllCategories();
	}

	@Override
	public Integer addCategory(Category category) {
		if (category.getId() == null) {
			if (category.getParentId() == null) {
				category.setParentId(0);
			}
			return categoryMapper.insertCategory(category);
		} else {
			return categoryMapper.updateCategory(category);
		}
	}

	@Override
	public Map<String, String> deleteCategory(Integer id) {
		Map<String, String> map = new HashMap<>();
		//1.判定当前分类节点是否有子分类。如果有，不能删除，提示有叶子节点
		Integer count = categoryMapper.getChildCategoryCount(id);
		if (count > 0) {
			map.put("code", "20011");
			map.put("msg", "该分类不是叶子节点");
			return map;
		}
		//2.如果当前分类下没有子分类，将该分类下所有商品信息中category_id设置为null
		
		//3.删除该分类
		count = categoryMapper.deleteCategoryById(id);
		if (count > 0) {
			map.put("code", "20010");
			map.put("msg", "删除分类成功");
		} else {
			map.put("code", "20012");
			map.put("msg", "删除分类失败");
		}
		return map;
	}

}
