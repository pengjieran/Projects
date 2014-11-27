package com.bean.service;

import com.bean.dao.UserDao;
import com.bean.entity.UserInfo;

public class UserService {
	
	private UserDao userDao;
	
	public UserInfo add() {
		
		UserInfo user = userDao.addUser();
		
		return user;
	}

}
