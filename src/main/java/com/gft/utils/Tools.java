package com.gft.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;


public final class Tools {

	private static Logger logger = Logger.getLogger(Tools.class);

	private Tools() {
	}


	/**
	 * 发送json数据
	 * 
	 * @param json
	 * @param response
	 */
	public static void writeJson(JSONObject json, HttpServletResponse response) {
		try {
			response.setContentType("text/xml; charset=utf-8");
			response.setCharacterEncoding("utf-8");
			Writer out = response.getWriter();
			System.out.println(json);
			out.write(json.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void print(String data, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			out.print(data);
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 输出json流到客户端 用于ajax交易
	 * 
	 * @param data
	 *            输出的数据对象
	 * @throws IOException
	 */
	public static void printJson(String data, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Set-Cookie", "HttpOnly");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(data);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}


	/**
	 * 获取客户端ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	public static String getLocationByIp(String ip) {
		String location = "";
		return location.length() > 1 ? location.substring(0, location.length() - 1) : location;
	}

	/**
	 * 获取随机验证码(英文不区分大小写)
	 * 
	 * @param length
	 *            验证码位数
	 * @param isAllNum
	 *            是否纯数字验证码
	 * @return
	 */
	public static String getCheckCode(int length, boolean isAllNum) {
		String str = "0123456789";
		if (!isAllNum)
			str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder(4);
		for (int i = 0; i < length; i++) {
			char ch = str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		return sb.toString();
	}

}
