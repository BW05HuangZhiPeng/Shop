/**
 * 
 * @Title:         CartServiceImpl.java
 * @Package        com.huangzhipeng.shop.service.impl
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月24日 下午6:43:54
 * @version:       V1.0
 */
package com.huangzhipeng.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;

import com.google.gson.Gson;
import com.huangzhipeng.shop.entity.Cart;
import com.huangzhipeng.shop.service.CartService;

/**   
 * @ClassName:     CartServiceImpl   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月24日 下午6:43:54     
 */
@Service
public class CartServiceImpl implements CartService {
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void addCart(Integer uid, Integer skuId, Integer num) {
		Gson gson = new Gson();
		// 向redis中添加购物车。
		// 数据类型是hash key：用户id field：商品id value：商品信息
		// 判断商品是否存在
		boolean hasKey = redisTemplate.opsForHash().hasKey("CART:" + uid, skuId + "");
		// 如果存在数量相加
		if (hasKey) {
			String json = (String) redisTemplate.opsForHash().get("CART:" + uid, skuId + "");
			// 把json转换成sku
			Cart cart = gson.fromJson(json, Cart.class);
			cart.setPnum(cart.getPnum() + num);
			//写回redis
			json = gson.toJson(cart);
			redisTemplate.opsForHash().put("CART:" + uid, skuId + "", json);
			return;
		}
		Cart cart = new Cart();
		cart.setUid(uid);
		// 设置购物车数据量
		cart.setPnum(num);
		cart.setSkuid(skuId);
		// 添加到购物车列表
		redisTemplate.opsForHash().put("CART:" + uid, skuId + "", gson.toJson(cart));
	}

	@Override
	public List<Cart> getCartList(Integer uid) {
		List<Cart> cartList = new ArrayList<>();
		List<String> jsonList = redisTemplate.opsForHash().values("CART:" + uid).stream().map(json -> String.valueOf(json)).collect(Collectors.toList());
		Gson gson = new Gson();
		for (String json : jsonList) {
			Cart cart = gson.fromJson(json, Cart.class);
			cartList.add(cart);
		}
		return cartList;
	}

	@Override
	public void updateCartNum(Integer uid, Integer skuId, Integer num) {
		//从redis中取商品信息
		String json = (String) redisTemplate.opsForHash().get("CART:" + uid, skuId + "");
		//更新商品数量
		Gson gson = new Gson();
		Cart cart = gson.fromJson(json, Cart.class);
		cart.setPnum(num);
		//写入redis
		redisTemplate.opsForHash().put("CART:" + uid, skuId + "", gson.toJson(cart));
	}

	@Override
	public void deleteCartItem(Integer uid, Integer skuId) {
		redisTemplate.opsForHash().delete("CART:" + uid, skuId + "");
	}

	@Override
	public void clearCart(Integer uid) {
		redisTemplate.opsForHash().delete("CART:" + uid);
	}
}
