/**
 * 
 * @Title:         User.java
 * @Package        com.huangzhipeng.shop.entity
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:53:22
 * @version:       V1.0
 */
package com.huangzhipeng.shop.entity;

import java.io.Serializable;

/**   
 * @ClassName:     User   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:53:22     
 */
public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2435231001764503205L;
	private Integer uid;
	private String username;
	private String password;
	private String name;
	private String email;
	private String telephone;
	private String birthday;
	private String sex;
	private Integer state;
	private String code;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer uid, String username, String password, String name, String email, String telephone,
			String birthday, String sex, Integer state, String code) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.birthday = birthday;
		this.sex = sex;
		this.state = state;
		this.code = code;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + ", birthday=" + birthday + ", sex=" + sex + ", state=" + state
				+ ", code=" + code + "]";
	}
	
}
