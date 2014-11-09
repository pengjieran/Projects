package com.bean;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

/**
 * 提供数据库连接，创建初始化数据的文件
 * @author Dean
 *
 */
public class TestUtils {
	
	private TestUtils() {}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
		
		return connection;
	}
}