/**
 * 
 * @Title:         UserController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��14�� ����7:59:17
 * @version:       V1.0
 */
package com.huangzhipeng.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huangzhipeng.shop.entity.Admin;
import com.huangzhipeng.shop.service.AdminService;

/**   
 * @ClassName:     UserController   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��14�� ����7:59:17     
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@Reference
	AdminService userService;
	
	/**
	 *  ��ת����¼ҳ��
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	/**
	 * ���ܵ�¼������
	 * @param request
	 * @param user
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,Admin user) {
		Admin loginUser = userService.login(user);
		if(loginUser!=null) {
			request.getSession().setAttribute("userinfo", loginUser);
			return "/Admin/index";
			
		}else {
			request.setAttribute("error", "�û����������");
			request.setAttribute("user",user);
			return "user/login";
		}
	}
	

	/**
	 *  ��ת��ע��ҳ��
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register() {
		return "user/register";
	}
	
	@RequestMapping("loginout")
	public String loginout(HttpServletRequest request) {
		request.getSession().removeAttribute("userinfo");
		return "/Admin/index";
	}
	
	/**
	 * ���ܵ���ע����
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,Admin user) {
		
		
		if(userService.register(user)>0) {
			return "redirect:login";
		}else {
			request.setAttribute("error", "ע��ʧ�ܣ����Ժ�����");
			return "user/register";
		}
		
	}

}
