/**
 * 
 * @Title:         OrderService.java
 * @Package        com.huangzhipeng.shop.service
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��25�� ����2:14:29
 * @version:       V1.0
 */
package com.huangzhipeng.shop.service;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Order;

/**   
 * @ClassName:     OrderService   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��25�� ����2:14:29     
 */
public interface OrderService {
	
	/**
	 * ���ɶ���
	 * @param order
	 * @return
	 */
	Integer createOrder(Order order);
	/**
	 * �ҵĶ���
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Order> orderList(Integer userId, Integer pageNum, Integer pageSize);
	/**   
	 * ��������
	 * @Title:         getOrderById   
	 * @Description:   TODO
	 * @param:         @param id
	 * @param:         @param skuId
	 * @param:         @return      
	 * @return:        Order     
	 * @date:          2019��11��26�� ����2:07:50   
	 * @throws   
	 */
	Order getOrderById(Integer id, Integer skuId);
	

}
