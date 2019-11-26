/**
 * 
 * @Title:         OrderServiceImpl.java
 * @Package        com.huangzhipeng.shop.service.impl
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��25�� ����2:22:15
 * @version:       V1.0
 */
package com.huangzhipeng.shop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.huangzhipeng.shop.dao.OrderMapper;
import com.huangzhipeng.shop.entity.Cart;
import com.huangzhipeng.shop.entity.Order;
import com.huangzhipeng.shop.entity.OrderDetail;
import com.huangzhipeng.shop.service.CartService;
import com.huangzhipeng.shop.service.OrderService;
import com.huangzhipeng.shop.service.SkuService;

/**   
 * @ClassName:     OrderServiceImpl   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��25�� ����2:22:15     
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderMapper orderMapper;
	
	@Reference
	private SkuService skuService;
	
	@Reference
	private CartService cartService;
	
	
	@Override
	public Integer createOrder(Order order) {
		order.setUserId(3);
		order.setStatus(1);
		order.setCreateTime(new Date());
		//����order
        orderMapper.insertOrder(order);
        
		for (OrderDetail orderDetail : order.getOrderDetails()) {
			orderDetail.setOrderId(order.getOrderId());
			//����detail
	        orderMapper.insertOrderDetail(orderDetail);
	        //�����
	        skuService.reduceStock(orderDetail.getSkuId(), orderDetail.getNum());
	        //ɾ�����ﳵ�ѹ���Ĺ�����
	        cartService.deleteCartItem(order.getUserId(), orderDetail.getSkuId());
		}
		
		return order.getOrderId();
	}
	@Override
	public Order getOrderById(Integer orderId,Integer skuId) {
		return orderMapper.selectOrderById(orderId,skuId);
	}
	@Override
	public PageInfo<Order> orderList(Integer userId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Order> orderList = orderMapper.selectOrderList(userId);
		for (Order order : orderList) {
			List<OrderDetail> orderDetailList = orderMapper.selectOrderDetailListByOrderId(order.getOrderId());
			order.setOrderDetails(orderDetailList);
		}
		PageInfo<Order> pageInfo = new PageInfo<>(orderList);
		return pageInfo;
	}
}
