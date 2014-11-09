package com.bean;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
	
	@SuppressWarnings("unused")
	@Test
	public void getdbInfo() {
		try {
			
			Connection connection = TestUtils.getConnection();
			String catalog = connection.getCatalog();
			System.out.println(catalog);
			
			//是否自动提交
			boolean autoCommit = connection.getAutoCommit();
			System.out.println(autoCommit);
			
			//事物级别
			int transactionIsolation = connection.getTransactionIsolation();
			System.out.println(transactionIsolation);
			
			//未知的一个功能
			Map<String, Class<?>> typeMap = connection.getTypeMap();
			Set<String> keySet = typeMap.keySet();
			for (String type : keySet) {
				
				System.out.println(type);
			}
			
			//获取客户端信息，不是太常用
			Properties clientInfo = connection.getClientInfo();
			
			//该数据库是否只读
			boolean readOnly = connection.isReadOnly();
			System.out.println(readOnly);
			
			//数据库相关信息,只写部分，其它不再一一列举
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println(databaseMetaData.getIdentifierQuoteString());
			System.out.println(databaseMetaData.getDatabaseProductName());
			
			String schema = connection.getSchema();
			System.out.println(schema);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}