package com.huangzhipeng.shop.entity;

import java.io.Serializable;


public class SkuSpec implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer skuId;
	private Integer specId;
	private Integer specOptionId;
	
	private String specName;
	private String specOptionName;
	
	
	public SkuSpec() {
		super();
	}

	/**
	 * @param id
	 * @param skuId
	 * @param specId
	 * @param specOptionId
	 * @param specName
	 * @param specOptionName
	 */
	public SkuSpec(Integer id, Integer skuId, Integer specId, Integer specOptionId, String specName,
			String specOptionName) {
		super();
		this.id = id;
		this.skuId = skuId;
		this.specId = specId;
		this.specOptionId = specOptionId;
		this.specName = specName;
		this.specOptionName = specOptionName;
	}

	
	/**
	 * @return the specName
	 */
	public String getSpecName() {
		return specName;
	}

	/**
	 * @param specName the specName to set
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}

	/**
	 * @return the specOptionName
	 */
	public String getSpecOptionName() {
		return specOptionName;
	}

	/**
	 * @param specOptionName the specOptionName to set
	 */
	public void setSpecOptionName(String specOptionName) {
		this.specOptionName = specOptionName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	public Integer getSpecId() {
		return specId;
	}
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	public Integer getSpecOptionId() {
		return specOptionId;
	}
	public void setSpecOptionId(Integer specOptionId) {
		this.specOptionId = specOptionId;
	}

	/**   
	 * @Title:         toString
	 * @Description:   TODO
	 * @date:          2019年11月21日 下午3:32:07  
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "SkuSpec [id=" + id + ", skuId=" + skuId + ", specId=" + specId + ", specOptionId=" + specOptionId
				+ ", specName=" + specName + ", specOptionName=" + specOptionName + "]";
	}
	
	
	
}
