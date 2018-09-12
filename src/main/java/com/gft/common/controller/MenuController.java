package com.gft.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gft.app.domain.AqMenu;
import com.gft.app.domain.AqUser;
import com.gft.app.service.SysService;
import com.gft.common.utils.Tools;

@Controller
public class MenuController {

	@Autowired
	private SysService sysService;
	
	
	@RequestMapping("/successLogin.do")
	public String successLogin(HttpServletRequest request){
		System.out.println("登录成功！");
		
		AqUser loginUser = (AqUser) request.getSession().getAttribute("LOGIN_USER");
		List<AqMenu> menuList = sysService.fineMenuListByUserId(loginUser.getId());
		if(null != menuList && menuList.size() > 0){
			Map<String, Object> menuinfo = setMenuinfoToSession(menuList);
			List<AqMenu> firstLevelMenu =  (List<AqMenu>) menuinfo.get("firstLevelMenu");
			Map<String, List<AqMenu>> secondLevelMenuMap = (Map<String, List<AqMenu>>) menuinfo.get("secondLevelMenuMap");
			
			request.getSession().setAttribute("firstLevelMenu", firstLevelMenu);
			request.getSession().setAttribute("secondLevelMenuMap", secondLevelMenuMap);
			
			String riderectUrl = "";
			AqMenu menu = menuList.get(0);
			String key = menu.getId();
			if(null == secondLevelMenuMap.get(key)){
				riderectUrl = menu.getUrl();
			}else{
				List<AqMenu> secondLevelMenu = secondLevelMenuMap.get(key);
				AqMenu sLevelmenu = secondLevelMenu.get(0);
				riderectUrl = sLevelmenu.getUrl();
			}
			return "redirect:" + riderectUrl;
		}
		return "welcome";
	}

	private Map<String, Object> setMenuinfoToSession(List<AqMenu> menuList) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<AqMenu> firstLevelMenu = new ArrayList<AqMenu>();
		Map<String, List<AqMenu>> secondLevelMenuMap = new HashMap<String, List<AqMenu>>();
		for(AqMenu menu : menuList){
			String url = menu.getUrl();
			if(StringUtils.isNotBlank(url)){
				if(url.contains("?")){
					menu.setUrl(url + "&menuId=" + menu.getId());
				}else{
					menu.setUrl(url + "?menuId=" + menu.getId());
				}
			}
			
			if(StringUtils.isBlank(menu.getParentid())){
				firstLevelMenu.add(menu);
			}else{
				String key = menu.getParentid();
				List<AqMenu> secondLevelMenu = secondLevelMenuMap.get(key);
				if(null == secondLevelMenu){
					secondLevelMenu = new ArrayList<AqMenu>();
					secondLevelMenuMap.put(key, secondLevelMenu);
				}
				secondLevelMenu.add(menu);
			}
		}
		
		result.put("firstLevelMenu", firstLevelMenu);
		result.put("secondLevelMenuMap", secondLevelMenuMap);
		return result;
	}
	
	@RequestMapping("/admin/menuManager.do")
	public String menuManager(HttpServletRequest request){
		System.out.println("跳转菜单管理！");
		
		AqMenu menu = new AqMenu();
		List<AqMenu> menuList = sysService.findAllMenu(menu);
		
		Map<String, Object> menuinfo = setMenuinfoToSession(menuList);
		List<AqMenu> firstLevelMenu =  (List<AqMenu>) menuinfo.get("firstLevelMenu");
		Map<String, List<AqMenu>> secondLevelMenuMap = (Map<String, List<AqMenu>>) menuinfo.get("secondLevelMenuMap");
		System.out.println(secondLevelMenuMap);
		request.setAttribute("menuList", firstLevelMenu);
		request.setAttribute("secondMap", secondLevelMenuMap);
		
		return "/sys/menuManager";
	}
	
	@RequestMapping("/admin/addMenu.do")
	public String addMenu(HttpServletRequest request){
		System.out.println("跳转菜单管理！");
		
		AqMenu menu = new AqMenu();
		List<AqMenu> menuList = sysService.findAllMenu(menu);
		
		Map<String, Object> menuinfo = setMenuinfoToSession(menuList);
		List<AqMenu> firstLevelMenu =  (List<AqMenu>) menuinfo.get("firstLevelMenu");
		Map<String, List<AqMenu>> secondLevelMenuMap = (Map<String, List<AqMenu>>) menuinfo.get("secondLevelMenuMap");
		
		request.setAttribute("menuList", firstLevelMenu);
		request.setAttribute("secondMap", secondLevelMenuMap);
		return "/sys/addMenu";
	}
	
	@RequestMapping("/admin/saveMenu.do")
	public String saveMenu(HttpServletRequest request, AqMenu menu){
		System.out.println("保存菜单！");
		if(null != menu){
			menu.setId(Tools.getUUID());
			menu.setDescription(" >> " + menu.getMenuname());
			sysService.insertMenu(menu);
		}
		return "redirect:/admin/menuManager.do";
	}
	
}
