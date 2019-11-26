/**
 * 
 * @Title:         OrderService.java
 * @Package        com.huangzhipeng.shop.service
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:14:29
 * @version:       V1.0
 */
package com.huangzhipeng.shop.service;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Order;

/**   
 * @ClassName:     OrderService   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:14:29     
 */
public interface OrderService {
	
	/**
	 * 生成订单
	 * @param order
	 * @return
	 */
	Integer createOrder(Order order);
	/**
	 * 我的订单
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Order> orderList(Integer userId, Integer pageNum, Integer pageSize);
	/**   
	 * 订单详情
	 * @Title:         getOrderById   
	 * @Description:   TODO
	 * @param:         @param id
	 * @param:         @param skuId
	 * @param:         @return      
	 * @return:        Order     
	 * @date:          2019年11月26日 下午2:07:50   
	 * @throws   
	 */
	Order getOrderById(Integer id, Integer skuId);
	

}
