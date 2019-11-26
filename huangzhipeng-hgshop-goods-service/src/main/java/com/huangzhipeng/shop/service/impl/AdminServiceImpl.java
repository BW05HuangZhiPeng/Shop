package com.huangzhipeng.shop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.huangzhipeng.shop.dao.AdminMapper;
import com.huangzhipeng.shop.entity.Admin;
import com.huangzhipeng.shop.service.AdminService;
import com.huangzhipeng.shop.util.Md5Utils;


/**
 * 
 * @author huangzhipeng
 *
 */
@Service
public class AdminServiceImpl  implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public int register(Admin user) {
		String md5 = Md5Utils.md5(user.getPassword());
		user.setPassword(md5);
		return adminMapper.add(user);
	}

	@Override
	public Admin login(Admin user) {
		Admin loginUser = adminMapper.findByUser(user.getName());
		// 用户存在 而且 密码不为空  且加密后的密码与数据库中的保存一致
		if(loginUser!=null && user.getPassword() !=null 
				&& Md5Utils.md5(user.getPassword())
				.equals(loginUser.getPassword())){
			return loginUser;
		}
		return null;
	}

}
