package com.gft.common.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gft.common.interceptor.LoginInterceptor;
import com.gft.common.utils.SysConfig;

/**
 * 拦截器配置类
 * @author weimj
 *
 */
@Configuration
public class InterceptorsConfig extends WebMvcConfigurerAdapter {

	String allowUrl = SysConfig.getApplicationPropStr("allowUrl");
	final String[] notLoginInterceptPaths = StringUtils.split(allowUrl, ",");
	
	@Bean
	public LoginInterceptor getLoginInterceptor(){
		return new LoginInterceptor();
	}
	
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：除了login，其他都拦截判断
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
        super.addInterceptors(registry);
    }
	
}
