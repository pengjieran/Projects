package com.bean;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	//插入数据
	@Test
	public void insert() {
	    
	    try {
		
		//单语句批量插入1000条记录
		Connection connection = TestUtils.getConnection();
		String sql = "insert into users(name, age, sex) values(?, ?, ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		for (int i = 0; i < 1000; i++) {
		    
		    prepareStatement.setString(1, "users" + i);
		    prepareStatement.setInt(2, i + 10);
		    prepareStatement.setString(3, (i / 2 == 0) ? "男" : "女");
		    prepareStatement.executeUpdate();
		}
		
	    } catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	    }
	}
	
	//查询
	@Test
	public void query() {
	    
	    try {
		
		Connection connection = TestUtils.getConnection();
		String sql = "select * from users";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
		    
		    String name = resultSet.getString("name");
		    int age = resultSet.getInt("age");
		    String sex = resultSet.getString("sex");
		    System.out.println(name + "===========" + age + "============" + sex);
		}
		
		
	    } catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	    }
	}
	
	//数据更新
	@Test
	public void update() {
	    
	    try {
		
		Connection connection = TestUtils.getConnection();
		
		String sql = "update users set sex = '男', name = 'aa', age = 25 where id = 1";
		Statement statement = connection.createStatement();
		int update = statement.executeUpdate(sql);
		connection.commit();
		System.out.println(update);
		
	    } catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	    }
	    
	}
	
	//删除
	@Test
	public void delete() {
	    
	    try {
		
		Connection connection = TestUtils.getConnection();
		String sql = "delete from users where id = 1";
		Statement statement = connection.createStatement();
		int i = statement.executeUpdate(sql);
		//autocommit=true的时候提交事物会报错
		//connection.commit();
		System.out.println(i);
	    } catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	    }
	}
}