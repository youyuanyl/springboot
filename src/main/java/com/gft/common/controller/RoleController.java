package com.gft.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gft.app.service.SysService;

@Controller
public class RoleController {
	
	@Autowired
	private SysService sysService;
	
	@RequestMapping("/admin/roleManager.do")
	public String roleManager(HttpServletRequest request){
		
		
		return "sys/role/roleManager";
	}
	
}
