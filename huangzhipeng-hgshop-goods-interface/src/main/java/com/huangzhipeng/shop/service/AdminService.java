package com.huangzhipeng.shop.service;

import com.huangzhipeng.shop.entity.Admin;

/**
 * 
 * @author huangzhipeng
 *
 */
public interface AdminService {
	
	/**
	 * 注册
	 * @param user
	 * @return  0 表示注册失败  >0 表示注册成功
	 */
	int register(Admin user);
	
	
	/**
	 *  登录
	 * @param user
	 * @return  null 表示登录失败   非空 登录成功
	 */
	Admin login(Admin user);
	
	
}
