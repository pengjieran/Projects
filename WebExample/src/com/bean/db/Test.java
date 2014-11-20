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
			
			Connection connection = DriverManager.getConnection(DBURL.getURL(DBType.ORACLE, "192.168.124.128", "1521", "xe", DBURL.UTF8), "sysdba", "");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
