/**
 * 
 * @Title:         UserController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����4:06:05
 * @version:       V1.0
 */
package com.huangzhipeng.shop.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.huangzhipeng.shop.entity.User;
import com.huangzhipeng.shop.service.UserService;


/**   
 * @ClassName:     UserController   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����4:06:05     
 */
@Controller
public class UserController {

	@Reference
	private UserService userService;
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping("/check")
	@ResponseBody
	public boolean check(String param, Integer type){
		return userService.check(param, type);
	}
	
	@PostMapping("/register")
	@ResponseBody
	public boolean register(User user) {
		return userService.register(user);
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> login(String name, String password, HttpServletResponse response) {
		Map<String, Object> map = userService.login(name, password);
		//���code=1000,��¼�ɹ���дtoken��cookie
		if (map.get("code").equals("1000")) {
			addCookie(map.get("msg").toString(), response);
		}
		return map;
	}
	
	private void addCookie(String token, HttpServletResponse response) {
		Cookie cookie = new Cookie("token", token);
		response.addCookie(cookie);
	}

	@RequestMapping("/logout")
	public String logout(String token) {
		userService.logout(token);
		return "login";
	}
	
	@RequestMapping("/token")
	@ResponseBody
	public Object getUserByToken(String token, String callback) {
		Map<String, Object> map = userService.getUserByToken(token);
		if (StringUtils.isNotBlank(callback)) {
			return new JSONPObject(callback, map);
		}
		return map;
	}
}
