package com.gft.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gft.app.domain.AqUser;
import com.gft.app.service.UserService;

public class InitListener implements ServletContextListener {

	private Logger logger = Logger.getLogger(InitListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("系统初始化开始。。。。。。");
		ServletContext sc = sce.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
		UserService userService = wac.getBean(UserService.class);
		
		
		logger.info("系统初始化完成！！！！！！");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("系统初始化失败！！！！！！");
	}
}
