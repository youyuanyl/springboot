package com.gft.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gft.app.domain.AqMenu;
import com.gft.app.domain.AqUser;
import com.gft.common.dao.BaseDAO;

@Mapper
public interface SysDAO extends BaseDAO<AqUser> {

	/**
	 * 根据用户ID获取菜单
	 * @param userId
	 * @return
	 */
	public List<AqMenu> fineMenuListByUserId(String userId);

	public AqMenu getMenuById(String menuId);

	public void insertMenu(AqMenu menu);

	public List<AqMenu> findAllMenu(AqMenu menu);
	
	
}
