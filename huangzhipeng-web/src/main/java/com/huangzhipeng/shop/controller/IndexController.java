/**
 * 
 * @Title:         IndexController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午4:11:19
 * @version:       V1.0
 */
package com.huangzhipeng.shop.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huangzhipeng.shop.entity.Category;
import com.huangzhipeng.shop.entity.Sku;
import com.huangzhipeng.shop.service.CategoryService;
import com.huangzhipeng.shop.service.SkuService;
/**   
 * @ClassName:     IndexController   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午4:11:19     
 */
@Controller
public class IndexController {
   
	@Reference
	private CategoryService categoryService;
	
	@Reference
	private SkuService skuService;
	
	@RequestMapping(value= {"/index","/",""},method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		//1.查询导航中的数据
		List<Category> navCategories = categoryService.getAllCategories();
		
		//2.查询最新商品数据
		List<Sku> newSkus = skuService.selectNews(4);
		
//		List<Sku> hotSkus = spuSkuService.selectHots(4);
		
		//存储数据
		request.setAttribute("navCategories", navCategories);
		request.setAttribute("newSkus", newSkus);
		request.setAttribute("hotSkus", newSkus);

		return "index";
	}
	/**
	 * 搜索页
	 * @param sku
	 * @param keyword
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("/shop")
	public String shop(Sku sku, String keyword, @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize, HttpServletRequest request) {
		sku.setTitle(keyword);
		System.err.println(sku);
		Map<String, Object> map = skuService.getSkuList(sku, pageNum, pageSize);
		request.setAttribute("map", map);
		return "shop";
	}
	
	/**
	 * 详情页
	 * @param request
	 * @param id
	 * @param optionIds
	 * @return
	 */
	@RequestMapping("/page")
	public String page(HttpServletRequest request, Integer id, Integer[] optionIds) {
		Map<String, Object> map = new HashMap<>();
		if (id != null) {
			map = skuService.getSkuById1(id);
		} else {
			map = skuService.getSkuBySpecOptionIds(optionIds);
		}
		
		request.setAttribute("map", map);
		return "page";
	}
	
	
	
//	@RequestMapping("/cart")
//	public String cart() {
//		return "cart";
//	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
}
