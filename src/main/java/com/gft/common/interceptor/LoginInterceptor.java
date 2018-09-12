package com.gft.common.interceptor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gft.app.domain.AqMenu;
import com.gft.app.service.SysService;

@Controller
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(LoginInterceptor.class);
	@Autowired
	private SysService sysService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		logger.info("------preHandle------");
		// 获取session
		HttpSession session = request.getSession(true);
		// 判断用户ID是否存在，不存在就跳转到登录界面
		if (null == session.getAttribute("LOGIN_USER")) {
			logger.info("------:跳转到login页面！");
			response.sendRedirect(request.getContextPath() + "/logout.do");
			return false;
		} else {
			session.setAttribute("LOGIN_USER", session.getAttribute("LOGIN_USER"));
			
			String currentLocation = "";
			String menuId = request.getParameter("menuId");
			if(StringUtils.isNotBlank(menuId)){
				AqMenu menu = sysService.getMenuById(menuId);
				if(null != menu){
					currentLocation = menu.getDescription();
				}
			}
			request.setAttribute("currentLocation", currentLocation);
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

}
