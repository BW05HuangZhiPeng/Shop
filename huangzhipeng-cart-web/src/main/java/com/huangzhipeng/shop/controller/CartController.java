/**
 * 
 * @Title:         CartController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:24:24
 * @version:       V1.0
 */
package com.huangzhipeng.shop.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huangzhipeng.shop.entity.Cart;
import com.huangzhipeng.shop.entity.Sku;
import com.huangzhipeng.shop.service.SkuService;
import com.huangzhipeng.shop.utils.JsonUtils;


/**   
 * @ClassName:     CartController   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:24:24     
 */
@Controller
public class CartController {

	@Reference
	private SkuService skuService;
	
	
	
	@RequestMapping("/cartAdd")
	public String cartAdd(HttpServletRequest request, HttpServletResponse response, Integer skuId, Integer num) {
		List<Cart> cartList = getCartListFromCookie(request);
		boolean flag = false;
		for (Cart cart : cartList) {
			// 如果存在数量相加
			if (cart.getSkuid() == skuId) {
				flag = true;
				// 找到商品，数量相加
				cart.setPnum(cart.getPnum() + num);
				// 跳出循环
				break;
			}
		}
		// 如果不存在
		if (!flag) {
			Cart cart = new Cart();
			cart.setPnum(num);
			cart.setSkuid(skuId);
			cartList.add(cart);
		}
		addCookie(cartList, response);
		// 返回添加成功页面
		return "redirect:/cartList";
	}
	
	
	
	private void addCookie(List<Cart> cartList, HttpServletResponse response) {
	Cookie cookie = new Cookie("cart", URLEncoder.encode(JsonUtils.objectToJson(cartList)));
		/*
		 * Gson gson = new Gson(); String json = gson.toJson(cartList); Cookie cookie =
		 * new Cookie("cart", URLEncoder.encode(json));
		 */
		cookie.setMaxAge(36000);
//		cookie.setPath("/");
//		cookie.setDomain("localhost:10010");
		response.addCookie(cookie);
	}

	@RequestMapping("/cartList")
	public String cartList(HttpServletRequest request, HttpServletResponse response) {
		// 从cookie中取购物车列表
		List<Cart> cartList = getCartListFromCookie(request);
		
		BigDecimal totalPrice = new BigDecimal(0);
		
		for (Cart cart : cartList) {
			if (cart.getSkuid()!=null) {
			Sku sku = skuService.getSkuById2(cart.getSkuid());
			cart.setTitle(sku.getTitle());
			cart.setImage(sku.getImage());
			cart.setPrice(sku.getPrice());
			cart.setSubPrice(cart.getPrice().multiply(new BigDecimal(cart.getPnum())));
					
			totalPrice=totalPrice.add(cart.getSubPrice());
			}
		}
		
		request.setAttribute("totalPrice", totalPrice);
		// 把列表传递给页面
		request.setAttribute("cartList", cartList);
		// 返回逻辑视图
		return "cart";
	}
	
	@RequestMapping("/cartUpdate")
	@ResponseBody
	public boolean updateCartNum(Integer skuId, Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		// 从cookie中取购物车列表
		List<Cart> cartList = getCartListFromCookie(request);
		// 遍历商品列表找到对应的商品
		for (Cart cart : cartList) {
			if (cart.getSkuid() == skuId) {
				cart.setPnum(num);
				break;
			}
		}
		// 把购物车列表写回cookie
		addCookie(cartList, response);
		// 返回成功
		return true;
	}

	/**
	 * 删除购物车商品
	 */
	@RequestMapping("/cartDelete")
	public String deleteCartItem(Integer skuId, HttpServletRequest request, HttpServletResponse response) {
		// 从cookie中取购物车列表
		List<Cart> cartList = getCartListFromCookie(request);
		// 遍历列表，找到要删除的商品
		for (Cart cart : cartList) {
			if (cart.getSkuid() == skuId) {
				// 删除商品
				cartList.remove(cart);
				// 跳出循环
				break;
			}
		}
		// 把购物车列表写入cookie
		addCookie(cartList, response);
		// 返回逻辑视图
		return "redirect:/cartList";
	}
	
	private List<Cart> getCartListFromCookie(HttpServletRequest request) {
		String json = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("cart".equalsIgnoreCase(cookie.getName())) {
				json = cookie.getValue();
				try {
					json = URLDecoder.decode(json, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// 判断json是否为空
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		// 把json转换成商品列表
//		Gson gson = new Gson();
		//List<Cart> list = gson.fromJson(json, Cart.class);
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		return list;
	}
	
}
