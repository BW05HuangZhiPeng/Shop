/**
 * 
 * @Title:         CartController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����3:24:24
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
 * @date:          2019��11��21�� ����3:24:24     
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
			// ��������������
			if (cart.getSkuid() == skuId) {
				flag = true;
				// �ҵ���Ʒ���������
				cart.setPnum(cart.getPnum() + num);
				// ����ѭ��
				break;
			}
		}
		// ���������
		if (!flag) {
			Cart cart = new Cart();
			cart.setPnum(num);
			cart.setSkuid(skuId);
			cartList.add(cart);
		}
		addCookie(cartList, response);
		// ������ӳɹ�ҳ��
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
		// ��cookie��ȡ���ﳵ�б�
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
		// ���б��ݸ�ҳ��
		request.setAttribute("cartList", cartList);
		// �����߼���ͼ
		return "cart";
	}
	
	@RequestMapping("/cartUpdate")
	@ResponseBody
	public boolean updateCartNum(Integer skuId, Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		// ��cookie��ȡ���ﳵ�б�
		List<Cart> cartList = getCartListFromCookie(request);
		// ������Ʒ�б��ҵ���Ӧ����Ʒ
		for (Cart cart : cartList) {
			if (cart.getSkuid() == skuId) {
				cart.setPnum(num);
				break;
			}
		}
		// �ѹ��ﳵ�б�д��cookie
		addCookie(cartList, response);
		// ���سɹ�
		return true;
	}

	/**
	 * ɾ�����ﳵ��Ʒ
	 */
	@RequestMapping("/cartDelete")
	public String deleteCartItem(Integer skuId, HttpServletRequest request, HttpServletResponse response) {
		// ��cookie��ȡ���ﳵ�б�
		List<Cart> cartList = getCartListFromCookie(request);
		// �����б��ҵ�Ҫɾ������Ʒ
		for (Cart cart : cartList) {
			if (cart.getSkuid() == skuId) {
				// ɾ����Ʒ
				cartList.remove(cart);
				// ����ѭ��
				break;
			}
		}
		// �ѹ��ﳵ�б�д��cookie
		addCookie(cartList, response);
		// �����߼���ͼ
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
		// �ж�json�Ƿ�Ϊ��
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		// ��jsonת������Ʒ�б�
//		Gson gson = new Gson();
		//List<Cart> list = gson.fromJson(json, Cart.class);
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		return list;
	}
	
}
