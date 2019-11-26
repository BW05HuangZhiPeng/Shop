/**
 * 
 * @Title:         UserServiceImpl.java
 * @Package        com.huangzhipeng.shop.service.impl
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午4:00:02
 * @version:       V1.0
 */
package com.huangzhipeng.shop.service.impl;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;

import com.google.gson.Gson;
import com.huangzhipeng.shop.dao.UserMapper;
import com.huangzhipeng.shop.entity.User;
import com.huangzhipeng.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public boolean check(String param, Integer type) {
		int count = userMapper.check(param, type);
		System.err.println(count);
		return count > 0;
	}

	@Override
	public boolean register(User user) {
		//激活状态：需要邮箱或手机号激活
		user.setState(0);
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		int count = userMapper.register(user);
		return count > 0;
	}

	@Override
	public Map<String, Object> login(String name, String password) {
		Map<String, Object> map = new HashMap<>();
		User user1 = userMapper.getUserBySearch(name);
		if (user1 != null) {
			password = DigestUtils.md5DigestAsHex(password.getBytes());
			if (user1.getPassword().equals(password)) {
				//session共享（使用redis替换session）
				String token = addUserToRedis(user1);
				map.put("code", "1000");
				map.put("msg", token);
			} else {
				map.put("code", "1002");
				map.put("msg", "密码不正确");
			}
		} else {
			map.put("code", "1001");
			map.put("msg", "用户名不正确");
		}
		return map;
	}

	private String addUserToRedis(User user) {
		user.setPassword(null);
		String token = UUID.randomUUID().toString(); 
		Gson gson = new Gson();
		gson.toJson(user);
		redisTemplate.opsForValue().set("SESSION:" + token, gson.toJson(user), 3600, TimeUnit.SECONDS);
		return token;
	}

	@Override
	public Map<String, Object> getUserByToken(String token) {
		Map<String, Object> map = new HashMap<>();
		String json = (String) redisTemplate.opsForValue().get("SESSION:" + token);
		if (StringUtils.isBlank(json)) {
			map.put("code", "1003");
			map.put("data", "用户登录已过期");
		} else {
			redisTemplate.expire("SESSION:" + token, 3600, TimeUnit.SECONDS);
			Gson gson = new Gson();
			map.put("code", "1000");
			map.put("data", gson.fromJson(json, User.class));
		}
		return map;
	}

	@Override
	public void logout(String token) {
		redisTemplate.delete("SESSION:" + token);
	}

	
	
}
