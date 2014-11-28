package com.bean.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.dao.UserDao;
import com.bean.entity.UserInfo;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public UserInfo add(UserInfo userinfo) {
		
		UserInfo user = userDao.addUser(userinfo);
		
		return user;
	}
	
	public List<UserInfo> getByName(String userName) throws SQLException {
		
		List<UserInfo> users = userDao.getByName(userName);
		
		return users;
	}

}