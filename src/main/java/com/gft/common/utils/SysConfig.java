package com.gft.common.utils;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 获取配置
 * @author weimj
 *
 */
public final class SysConfig {

	private SysConfig(){}
	private static Logger logger = Logger.getLogger(SysConfig.class);
	
	/**
	 * 获取自定义properties配置文件内容
	 * @param key
	 * @return 字符串
	 */
	public static String getConfigStr(String propertiesName, String key){
		String str = "";
		try {
			str = getResourceBundle(propertiesName).getString(key);
		} catch (Exception e) {
			logger.error("获取config.properties配置文件内容出错，key-"+key, e);
		}
		return str;
	}
	
	/**
	 * 获取自定义properties配置文件内容
	 * @param key
	 * @return 整数
	 */
	public static Integer getConfigInt(String propertiesName, String key){
		Integer num = null;
		String str = getConfigStr(propertiesName, key);
		if(StringUtils.isNotBlank(str)){
			try {
				num = Integer.parseInt(str);
			} catch (Exception e) {
				logger.error("获取config.properties配置文件内容出错，key-"+key, e);
			}
		}
		return num;
	}
	
	/**
	 * 获取自定义properties配置文件内容
	 * @param key
	 * @return 小数
	 */
	public static Double getConfigDouble(String propertiesName, String key){
		Double dou = null;
		String str = getConfigStr(propertiesName, key);
		if(StringUtils.isNotBlank(str)){
			try {
				dou = Double.parseDouble(str);
			} catch (Exception e) {
				logger.error("获取config.properties配置文件内容出错，key-"+key, e);
			}
		}
		return dou;
	}
	

	
	
	/**
	 * 获取application配置
	 * @param key
	 * @return 字符串值
	 */
	public static String getApplicationPropStr(String key){
		String str = "";
		boolean flag = false;
		String active = "";
		try {
			active = getResourceBundle("application").getString("spring.profiles.active");
		} catch (Exception e) {
		}
		if(StringUtils.isNotBlank(active)){
			try {
				str = getResourceBundle("application-" + active).getString(key);
			} catch (Exception e) {
			}
			if(StringUtils.isNotBlank(str)){
				flag = true;
			}
		}
		if(!flag){
			try {
				str = getResourceBundle("application").getString(key);
			} catch (Exception e) {
			}
		}
		if(StringUtils.isBlank(str)){
			logger.error("获取application配置文件内容出错，key-"+key);
		}
		return str;
	}
	
	/**
	 * 获取application配置
	 * @param key
	 * @return 整数值
	 */
	public static Integer getApplicationPropInt(String key){
		String strValue = getApplicationPropStr(key);
		Integer num = null;
		try {
			if(StringUtils.isNotBlank(strValue)){
				num = Integer.parseInt(strValue);
			}
		} catch (NumberFormatException e) {
			logger.error("获取application配置文件数值内容出错，key-"+key);
		}
		return num;
	}
	
	/**
	 * 获取application配置
	 * @param key
	 * @return 浮点类型数值（小数）
	 */
	public static Double getApplicationPropDouble(String key){
		String strValue = getApplicationPropStr(key);
		Double num = null;
		try {
			if(StringUtils.isNotBlank(strValue)){
				num = Double.parseDouble(strValue);
			}
		} catch (NumberFormatException e) {
			logger.error("获取application配置文件小数内容出错，key-"+key);
		}
		return num;
	}
	
	
	/**
	 * @function getResourceBundle
	 * @return ResourceBundles
	 */
	private static ResourceBundle getResourceBundle(String propertiesName) {
		ResourceBundle propBundle = null;
		try {
			propBundle = ResourceBundle.getBundle(propertiesName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propBundle;
	}
	
}
