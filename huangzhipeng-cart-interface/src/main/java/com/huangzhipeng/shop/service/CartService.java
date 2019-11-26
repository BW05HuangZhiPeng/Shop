/**
 * 
 * @Title:         CartService.java
 * @Package        com.huangzhipeng.shop.service
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月24日 下午6:33:56
 * @version:       V1.0
 */
package com.huangzhipeng.shop.service;

import java.util.List;

import com.huangzhipeng.shop.entity.Cart;

/**   
 * @ClassName:     CartService   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月24日 下午6:33:56     
 */
public interface CartService {


	void addCart(Integer uid, Integer skuId, Integer num);

	List<Cart> getCartList(Integer uid);

	void updateCartNum(Integer uid, Integer skuId, Integer num);

	void deleteCartItem(Integer uid, Integer skuId);

	void clearCart(Integer uid);
}
