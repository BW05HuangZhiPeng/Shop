/**
 * 
 * @Title:         OrderDetail.java
 * @Package        com.huangzhipeng.shop.entity
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:12:50
 * @version:       V1.0
 */
package com.huangzhipeng.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**   
 * @ClassName:     OrderDetail   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月25日 下午2:12:50     
 */
public class OrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5446078647996775010L;
	private Integer id;
	private Integer orderId; //订单号
	private Integer skuId;	//商品id
	private Integer num; //数量
	private String title; //标题
	private BigDecimal price; //价格
	private String image; //图片
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param orderId
	 * @param skuId
	 * @param num
	 * @param title
	 * @param price
	 * @param image
	 */
	

	public Integer getId() {
		return id;
	}
	/**
	 * @param id
	 * @param orderId
	 * @param skuId
	 * @param num
	 * @param title
	 * @param price
	 * @param image
	 */
	public OrderDetail(Integer id, Integer orderId, Integer skuId, Integer num, String title, BigDecimal price,
			String image) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.skuId = skuId;
		this.num = num;
		this.title = title;
		this.price = price;
		this.image = image;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	


	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	/**   
	 * @Title:         toString
	 * @Description:   TODO
	 * @date:          2019年11月26日 上午10:15:49  
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", skuId=" + skuId + ", num=" + num + ", title="
				+ title + ", price=" + price + ", image=" + image + "]";
	}

	
	

}
