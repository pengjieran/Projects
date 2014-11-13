package com.bean.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;

public class DBUtilsTest {
    
    private static final String url = "jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8";
    
    private static final String user = "root";
    
    private static final String password = "root";
    
    @Test
    public void DBTest() {
	
	try {
	    
	    Connection connection = getInstance(DBDriver.MYSQLDRIVER, url, user, password);
	    DbUtils.close(connection);
	} catch (SQLException e) {
	    
	    e.printStackTrace();
	}
	
    }
    
    private Connection getInstance(String driverName, String url, String user, String password) throws SQLException {
	
	//加载数据库驱动
	DbUtils.loadDriver(driverName);
	//获取链接
	Connection connection = DriverManager.getConnection(url, user, password);
	
	return connection;
    }
}