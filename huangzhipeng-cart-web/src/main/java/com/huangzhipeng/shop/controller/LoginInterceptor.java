package com.huangzhipeng.shop.controller;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.huangzhipeng.shop.entity.User;
import com.huangzhipeng.shop.service.UserService;


/**
 * �û���¼����������
 * <p>Title: LoginInterceptor</p>
 */
public class LoginInterceptor implements HandlerInterceptor {
	

	@Reference
	private UserService userService;

	private String getTokenFromCookie(HttpServletRequest request) {
		String token = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("token".equalsIgnoreCase(cookie.getName())) {
				token = cookie.getValue();
				break;
			}
		}
		return token;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// ǰ����ִ��handler֮ǰִ�д˷�����
		//����true������	false������
		//1.��cookie��ȡtoken
		String token = getTokenFromCookie(request);
		//2.���û��token��δ��¼״̬��ֱ�ӷ���
		if (StringUtils.isBlank(token)) {
			return true;
		}
		//3.ȡ��token����Ҫ�����û����񣬸���tokenȡ�û���Ϣ
		Map<String, Object> map = userService.getUserByToken(token);
		//4.û��ȡ���û���Ϣ����¼���ڣ�ֱ�ӷ��С�
		if (!"1000".equals(map.get("code").toString())) {
			return true;
		}
		//5.ȡ���û���Ϣ����¼״̬��
		User user = (User) map.get("data");
		//6.���û���Ϣ�ŵ�request�С�ֻ��Ҫ��Controller���ж�request���Ƿ����user��Ϣ������
		request.setAttribute("user", user);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		//handlerִ��֮�󣬷���ModeAndView֮ǰ
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//��ɴ�������ModelAndView֮��
		//�����ٴ˴����쳣

	}

}
