package com.gft.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gft.app.dao.UserDAO;
import com.gft.app.domain.AqUser;

@Service
public class UserService {

	@Resource
	private UserDAO userDAO;
	
	public List<AqUser> select(){
		return userDAO.select();
	}

	public AqUser getUser(AqUser user) {
		List<AqUser> list = userDAO.select(user);
		if(null != list && list.size() > 0) return list.get(0);
		return null;
	}

	public void insert(AqUser user) {
		userDAO.insert(user);
	}
	
}
