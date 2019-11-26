/**
 * 
 * @Title:         OrderController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:33:17
 * @version:       V1.0
 */
package com.huangzhipeng.shop.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Cart;
import com.huangzhipeng.shop.entity.Order;
import com.huangzhipeng.shop.entity.Sku;
import com.huangzhipeng.shop.service.CartService;
import com.huangzhipeng.shop.service.OrderService;
import com.huangzhipeng.shop.service.SkuService;

/**   
 * @ClassName:     OrderController   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:33:17     
 */
@Controller
public class OrderController {
	@Reference
	private OrderService orderService;
	
	@Reference
	private CartService cartService;
	
	@Reference
	private SkuService skuService;
	
	@RequestMapping("/checkOut")
	public String checkOut() {
		return "checkout";
	}
	
	@RequestMapping("/addressAdd")
	public String addressAdd() {
		//添加收货地址
		return "redirect:/orderOverview";
	}
	
	@RequestMapping("/orderOverview")
	public String orderOverview(HttpServletRequest request) {
		List<Cart> cartList = cartService.getCartList(3);
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
		return "order_overview";
	}
	
	@RequestMapping(value="/orderCreate")
	public String orderCreate(Order order, HttpServletRequest request) {
		Integer orderId = orderService.createOrder(order);
		request.setAttribute("orderId", orderId);
		request.setAttribute("actualPrice",order.getActualPrice());
		if (order.getPaymentType() == 1) {
			return "redirect:/payment";
		} else {
			return "redirect:/pay";
		}
	}
	
	@RequestMapping("/payment")
	public String payment() {
		return "payment";
	}
	
	@RequestMapping("/pay")
	public String pay() {
		return "order_complete";
	}
	
	@RequestMapping("/orderList")
	public String orderList(Model model, @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize) {
		//1.获取数据
		Integer userId = 3;
		PageInfo<Order> pageInfo = orderService.orderList(userId, pageNum, pageSize);
		for (Order iterable_element : pageInfo.getList()) {
			System.out.println(iterable_element);
		}
		//2.填充数据
		model.addAttribute("pageInfo", pageInfo);
		return "account";
	}
	
	@RequestMapping("/getOrderById")
	public String getOrderById(Integer id,Integer skuId,HttpServletRequest request){
		Order order = orderService.getOrderById(id,skuId);
		request.setAttribute("order", order);
		return "order_detail";
	}
	
	/*@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //注册自定义的编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }*/
}
