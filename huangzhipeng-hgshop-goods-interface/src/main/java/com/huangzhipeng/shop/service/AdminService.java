package com.huangzhipeng.shop.service;

import com.huangzhipeng.shop.entity.Admin;

/**
 * 
 * @author huangzhipeng
 *
 */
public interface AdminService {
	
	/**
	 * ע��
	 * @param user
	 * @return  0 ��ʾע��ʧ��  >0 ��ʾע��ɹ�
	 */
	int register(Admin user);
	
	
	/**
	 *  ��¼
	 * @param user
	 * @return  null ��ʾ��¼ʧ��   �ǿ� ��¼�ɹ�
	 */
	Admin login(Admin user);
	
	
}
