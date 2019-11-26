/**
 * 
 * @Title:         OrderMapper.java
 * @Package        com.huangzhipeng.shop.dao
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:20:49
 * @version:       V1.0
 */
package com.huangzhipeng.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huangzhipeng.shop.entity.Order;
import com.huangzhipeng.shop.entity.OrderDetail;

/**   
 * @ClassName:     OrderMapper   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:20:49     
 */
public interface OrderMapper {

	void insertOrder(Order order);

	void insertOrderDetail(OrderDetail orderDetail);

	Order selectOrderById(@Param("orderId")Integer orderId,@Param("skuId")Integer skuId);

	List<Order> selectOrderList(Integer userId);

	List<OrderDetail> selectOrderDetailListByOrderId(Integer orderId);
}
