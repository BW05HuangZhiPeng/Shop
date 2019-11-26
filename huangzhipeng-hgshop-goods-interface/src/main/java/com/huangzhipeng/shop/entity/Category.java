package com.huangzhipeng.shop.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6521715292542467589L;
	/**
	 * 
	 */

	private Integer id;
	@JsonProperty("text")
	private String name;
	private Integer parentId;
	@JsonProperty("nodes")
	private List<Category> childs;
	 private boolean selectable = true; 

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, String name, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Category> getChilds() {
		return childs;
	}

	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}

		/**
			 * @return the selectable
			 */

	
	  public boolean isSelectable() { return selectable; }
	 /**
		 * @param selectable the selectable to set
		 */
			  public void setSelectable(boolean selectable) { this.selectable = selectable;
			  }
			 
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentId=" + parentId + ", childs=" + childs + "]";
	}

}
