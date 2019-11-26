/**
 * 
 * @Title:         Cart.java
 * @Package        com.huangzhipeng.shop.entity
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:17:18
 * @version:       V1.0
 */
package com.huangzhipeng.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**   
 * @ClassName:     Cart   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:17:18     
 */
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private Integer skuid;
	private Integer pnum;
	private Date createtime;
	private Date updatetime;
	
	private String image;
	private String title;
	private BigDecimal price;
	private BigDecimal subPrice;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Integer id, Integer uid, Integer skuid, Integer pnum, Date createtime, Date updatetime) {
		super();
		this.id = id;
		this.uid = uid;
		this.skuid = skuid;
		this.pnum = pnum;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getSkuid() {
		return skuid;
	}
	public void setSkuid(Integer skuid) {
		this.skuid = skuid;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSubPrice() {
		return subPrice;
	}
	public void setSubPrice(BigDecimal subPrice) {
		this.subPrice = subPrice;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", skuid=" + skuid + ", pnum=" + pnum + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + "]";
	}
	
	
}
