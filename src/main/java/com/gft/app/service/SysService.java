package com.gft.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gft.app.dao.SysDAO;
import com.gft.app.domain.AqMenu;

@Service
public class SysService {

	@Resource
	private SysDAO sysDAO;

	/**
	 * 根据用户ID获取菜单
	 * @param userId
	 * @return
	 */
	public List<AqMenu> fineMenuListByUserId(String userId) {
		System.out.println("userId:---" + userId + "******");
		return sysDAO.fineMenuListByUserId(userId);
	}

	public AqMenu getMenuById(String menuId) {
		return sysDAO.getMenuById(menuId);
	}

	public void insertMenu(AqMenu menu) {
		sysDAO.insertMenu(menu);
	}

	public List<AqMenu> findAllMenu(AqMenu menu) {
		return sysDAO.findAllMenu(menu);
	}
	
	
	
}
