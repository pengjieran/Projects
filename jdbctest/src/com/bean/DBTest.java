package com.bean;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DBTest {
	
	@Test
	public void getConnection() {
		
		try {
			
			Connection connection = TestUtils.getConnection();
			if (null == connection) {
				
				System.out.println("数据库连接失败！");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void getdbInfo() {
		try {
			
			Connection connection = TestUtils.getConnection();
			String catalog = connection.getCatalog();
			System.out.println(catalog);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}