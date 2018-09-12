package com.gft.app.dao;

import org.apache.ibatis.annotations.Mapper;

import com.gft.app.domain.AqUser;
import com.gft.common.dao.BaseDAO;

@Mapper
public interface UserDAO extends BaseDAO<AqUser> {

	
}
