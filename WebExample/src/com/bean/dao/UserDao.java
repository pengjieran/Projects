package com.bean.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bean.db.DBUtils;
import com.bean.entity.UserInfo;

public class UserDao {
	
	private Connection connection = DBUtils.connection;
	
	private QueryRunner queryRunner = new QueryRunner();
	
	public UserInfo get(String id) throws SQLException {
		
		BeanHandler<UserInfo> beanHandler = new BeanHandler<UserInfo>(UserInfo.class);
		
		UserInfo userInfo = queryRunner.query(connection, "select * from userinfo where id = ?", beanHandler, new Object[]{id});
		
		return userInfo;
	}
	
	public List<UserInfo> getByName(String userName) throws SQLException {
		
		BeanListHandler<UserInfo> beanListHandler = new BeanListHandler<UserInfo>(UserInfo.class);
		
		List<UserInfo> query = queryRunner.query(connection, "select * from userinfo where username = ?", beanListHandler, new Object[]{userName});
		
		return query;
	}
	
	public UserInfo addUser(UserInfo user) {
		
		return null;
	}

}
