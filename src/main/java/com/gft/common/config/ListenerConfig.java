package com.gft.common.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gft.common.listener.InitListener;

/**
 * 监听器配置类
 * @author weimj
 *
 */
@Configuration
public class ListenerConfig {
	
	/**
     * 注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<InitListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<InitListener>(new InitListener());
    }
	
	
}
