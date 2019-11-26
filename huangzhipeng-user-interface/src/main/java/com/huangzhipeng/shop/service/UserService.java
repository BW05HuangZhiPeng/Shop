/**
 * 
 * @Title:         UserService.java
 * @Package        com.huangzhipeng.shop.service
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:54:11
 * @version:       V1.0
 */
package com.huangzhipeng.shop.service;

import java.util.Map;

import com.huangzhipeng.shop.entity.User;

/**   
 * @ClassName:     UserService   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:54:11     
 */
public interface UserService {
	boolean check(String param, Integer type);

	boolean register(User user);

	Map<String, Object> login(String name, String password);

	Map<String, Object> getUserByToken(String token);

	void logout(String token);
}
