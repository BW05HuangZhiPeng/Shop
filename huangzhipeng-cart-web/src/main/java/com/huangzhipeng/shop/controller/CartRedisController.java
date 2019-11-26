package com.huangzhipeng.shop.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangzhipeng.shop.entity.Cart;
import com.huangzhipeng.shop.entity.Sku;
import com.huangzhipeng.shop.entity.User;
import com.huangzhipeng.shop.service.CartService;
import com.huangzhipeng.shop.service.SkuService;

@Controller
public class CartRedisController {

	
	@Reference
	private SkuService skuService;
	
	@Reference
	private CartService cartService;
	
	@RequestMapping("/cartAdd2")
	public String cartAdd(HttpServletRequest request, HttpServletResponse response, Integer skuId, Integer num) {
		// 判断用户是否登录
		User user = (User) request.getAttribute("user");
		// 如果是登录状态，把购物车写入redis
		if (user != null) {
			// 保存到服务端
			cartService.addCart(user.getUid(), skuId, num);
		}
		// 返回逻辑视图
		return "redirect:/cartList2";
	}
	
	@RequestMapping("/cartList2")
	public String cartList(HttpServletRequest request, HttpServletResponse response) {
		List<Cart> cartList = new ArrayList<>();
		
		// 判断用户是否为登录状态
		User user = (User) request.getAttribute("user");
		// 如果是登录状态
		if (user != null) {
			// 从服务端取购物车列表
			cartList = cartService.getCartList(user.getUid());
		}
		
		
		BigDecimal totalPrice = new BigDecimal(0);
		
		for (Cart cart : cartList) {
			Sku sku = skuService.getSkuById2(cart.getSkuid());
			cart.setTitle(sku.getTitle());
			cart.setImage(sku.getImage());
			cart.setPrice(sku.getPrice());
			cart.setSubPrice(cart.getPrice().multiply(new BigDecimal(cart.getPnum())));
			totalPrice = totalPrice.add(cart.getSubPrice());
		}
		
		request.setAttribute("totalPrice", totalPrice);
		// 把列表传递给页面
		request.setAttribute("cartList", cartList);
		System.err.println(cartList);
		// 返回逻辑视图
		return "cart";
	}
	
	@RequestMapping("/cartUpdate2")
	@ResponseBody
	public boolean updateCartNum(Integer skuId, Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		// 判断用户是否为登录状态
		User user = (User) request.getAttribute("user");
		if (user != null) {
			cartService.updateCartNum(user.getUid(), skuId, num);
		}
		// 返回成功
		return true;
	}

	/**
	 * 删除购物车商品
	 */
	@RequestMapping("/cartDelete2")
	public String deleteCartItem(Integer skuId, HttpServletRequest request, HttpServletResponse response) {
		// 判断用户是否为登录状态
		User user = (User) request.getAttribute("user");
		if (user != null) {
			cartService.deleteCartItem(user.getUid(), skuId);
		}
		// 返回逻辑视图
		return "redirect:/cartList2";
	}
	
	
	/**
	 * 清空购物车
	 */
	@RequestMapping("/cartClear2")
	public String clearCart(HttpServletRequest request, HttpServletResponse response) {
		// 判断用户是否为登录状态
		User user = (User) request.getAttribute("user");
		if (user != null) {
			cartService.clearCart(user.getUid());
		}
		// 返回逻辑视图
		return "redirect:/cartList2";
	}
			 
}
