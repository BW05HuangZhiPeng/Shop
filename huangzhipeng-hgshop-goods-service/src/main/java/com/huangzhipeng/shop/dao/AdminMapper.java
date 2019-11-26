package com.huangzhipeng.shop.dao;

import org.apache.ibatis.annotations.Select;

import com.huangzhipeng.shop.entity.Admin;

/**
 * 
 * @author huangzhipeng
 *
 */
public interface AdminMapper {

	
	int add(Admin user);
	

	/**   
	 * @Title:         findByUser   
	 * @Description:   TODO
	 * @param:         @param name
	 * @param:         @return      
	 * @return:        User     
	 * @date:          2019年11月14日 下午8:09:44   
	 * @throws   
	 */
	@Select("select * from hg_user where name=#{name}")
	Admin findByUser(String name);

}
