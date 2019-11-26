/**
 * 
 * @Title:         Order.java
 * @Package        com.huangzhipeng.shop.entity
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:12:03
 * @version:       V1.0
 */
package com.huangzhipeng.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**   
 * @ClassName:     Order   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:12:03     
 */
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 194577989042670882L;
	private Integer orderId; //订单号
	private BigDecimal totalPrice; //总价(没有加运费)
	private BigDecimal actualPrice; //实际价格(总价 +运费)
	private BigDecimal postFee; //运费
	private Integer paymentType; //支付方式
	private Integer userId; //用户id
	private Integer status; //订单状态(待付款/已付款/待发货/已发货/已收货/自动关闭)    还有订单各个状态对应的时间 
	private Date createTime; //生成时间

	private List<OrderDetail> orderDetails;
	
	//物流/买家留言/收货人信息/发票信息
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param orderId
	 * @param totalPrice
	 * @param actualPrice
	 * @param postFee
	 * @param paymentType
	 * @param userId
	 * @param status
	 * @param createTime
	 * @param orderDetails
	 */
	public Order(Integer orderId, BigDecimal totalPrice, BigDecimal actualPrice, BigDecimal postFee,
			Integer paymentType, Integer userId, Integer status, Date createTime, List<OrderDetail> orderDetails) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.actualPrice = actualPrice;
		this.postFee = postFee;
		this.paymentType = paymentType;
		this.userId = userId;
		this.status = status;
		this.createTime = createTime;
		this.orderDetails = orderDetails;
	}


	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @param actualPrice the actualPrice to set
	 */
	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}
	

	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	/**
	 * @return the actualPrice
	 */
	public BigDecimal getActualPrice() {
		return actualPrice;
	}


	/**
	 * @return the postFee
	 */
	public BigDecimal getPostFee() {
		return postFee;
	}


	/**
	 * @param postFee the postFee to set
	 */
	public void setPostFee(BigDecimal postFee) {
		this.postFee = postFee;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	/**   
	 * @Title:         toString
	 * @Description:   TODO
	 * @date:          2019年11月26日 上午10:12:43  
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalPrice=" + totalPrice + ", actualPrice=" + actualPrice
				+ ", postFee=" + postFee + ", paymentType=" + paymentType + ", userId=" + userId + ", status=" + status
				+ ", createTime=" + createTime + ", orderDetails=" + orderDetails + "]";
	}
	
}
