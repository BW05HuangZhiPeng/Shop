package com.huangzhipeng.shop.controller;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangzhipeng.shop.entity.Category;
import com.huangzhipeng.shop.service.CategoryService;



@Controller
@RequestMapping("/Category")
public class CategoryController {

	@Reference
	private CategoryService categoryService;
	
	@RequestMapping("/categoryList")
	public String categoryList(){
		return "/category/category_list";
	}
	
	@RequestMapping("/categoryLists")
	@ResponseBody
	public List<Category> categoryLists(){
		return categoryService.getAllCategories();
	}
	
	
	  @RequestMapping("/categoryLists1")
	  
	  @ResponseBody public List<Category> categoryLists1(){
	 List<Category> list =categoryService.getAllCategories(); 
	  list.forEach(c -> {
	  c.setSelectable(false); c.getChilds().forEach(c1 -> c1.setSelectable(false));
	  }); 
	  return list; 
	  }
	 
	
	@RequestMapping("/categoryAdd")
	@ResponseBody
	public boolean categoryAdd(Category category){
		return categoryService.addCategory(category) > 0;
	}
	
	@RequestMapping("/categoryDelete")
	@ResponseBody
	public Map<String, String> categoryDelete(Integer id){
		return categoryService.deleteCategory(id);
	}
	
	
}
