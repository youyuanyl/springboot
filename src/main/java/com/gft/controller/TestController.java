package com.gft.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gft.service.RedisService;
import com.gft.utils.AESUtil;
import com.gft.utils.Tools;

import net.sf.json.JSONObject;

@Controller
public class TestController {

	@Autowired
	private RedisService redisService;

	@RequestMapping("/test.do")
	public String test(HttpServletRequest request) {
		/*
		 * System.out.println(redisService.get("kafka-words-count")); System.out.println(AESUtil.decrypt((String)redisService.get("kafka-words-count"), "kafka-words-count"));
		 */

		// request.setAttribute("data", AESUtil.decrypt((String)redisService.get("kafka-words-count"), "kafka-words-count"));

		return "test";
	}

	@RequestMapping("/getData.do")
	public String getData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(redisService.get("kafka-words-count"));
		String arrayStr = AESUtil.decrypt((String) redisService.get("kafka-words-count"), "kafka-words-count");
		Tools.print(arrayStr, response);
		return null;
	}

	@RequestMapping("/upload.do")
	public String upload(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
			String key = (String) it.next();
			MultipartFile file = multipartRequest.getFile(key);
			String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();// 获得文件扩展名

			String originalname = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));// 获得原文件名称
			System.out.println(originalname);
		}
		return null;
	}

}
