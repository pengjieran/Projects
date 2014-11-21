package com.bean.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.bean.db.DBURL.DBType;

public class Test {

	public static void main(String[] args) {
		
		DbUtils.loadDriver(DBDriver.ORACLE);
		try {
			
			Connection connection = DriverManager.getConnection(DBURL.getURL(DBType.MYSQL, "localhost", "3306", "testdb", DBURL.UTF8), "root", "root");
			
			System.out.println(connection.getAutoCommit());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
