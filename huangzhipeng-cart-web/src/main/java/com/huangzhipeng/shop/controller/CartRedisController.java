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
		// �ж��û��Ƿ��¼
		User user = (User) request.getAttribute("user");
		// ����ǵ�¼״̬���ѹ��ﳵд��redis
		if (user != null) {
			// ���浽�����
			cartService.addCart(user.getUid(), skuId, num);
		}
		// �����߼���ͼ
		return "redirect:/cartList2";
	}
	
	@RequestMapping("/cartList2")
	public String cartList(HttpServletRequest request, HttpServletResponse response) {
		List<Cart> cartList = new ArrayList<>();
		
		// �ж��û��Ƿ�Ϊ��¼״̬
		User user = (User) request.getAttribute("user");
		// ����ǵ�¼״̬
		if (user != null) {
			// �ӷ����ȡ���ﳵ�б�
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
		// ���б��ݸ�ҳ��
		request.setAttribute("cartList", cartList);
		System.err.println(cartList);
		// �����߼���ͼ
		return "cart";
	}
	
	@RequestMapping("/cartUpdate2")
	@ResponseBody
	public boolean updateCartNum(Integer skuId, Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		// �ж��û��Ƿ�Ϊ��¼״̬
		User user = (User) request.getAttribute("user");
		if (user != null) {
			cartService.updateCartNum(user.getUid(), skuId, num);
		}
		// ���سɹ�
		return true;
	}

	/**
	 * ɾ�����ﳵ��Ʒ
	 */
	@RequestMapping("/cartDelete2")
	public String deleteCartItem(Integer skuId, HttpServletRequest request, HttpServletResponse response) {
		// �ж��û��Ƿ�Ϊ��¼״̬
		User user = (User) request.getAttribute("user");
		if (user != null) {
			cartService.deleteCartItem(user.getUid(), skuId);
		}
		// �����߼���ͼ
		return "redirect:/cartList2";
	}
	
	
	/**
	 * ��չ��ﳵ
	 */
	@RequestMapping("/cartClear2")
	public String clearCart(HttpServletRequest request, HttpServletResponse response) {
		// �ж��û��Ƿ�Ϊ��¼״̬
		User user = (User) request.getAttribute("user");
		if (user != null) {
			cartService.clearCart(user.getUid());
		}
		// �����߼���ͼ
		return "redirect:/cartList2";
	}
			 
}
