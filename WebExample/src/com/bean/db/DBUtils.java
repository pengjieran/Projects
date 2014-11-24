package com.bean.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DBUtils {
	
	public static Connection connection;
	
	static {
		
		Context context = null ;
		try {
			
			context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:jboss/datasources/mysqlDS");
			
			if (null == connection )
			{				
				connection = dataSource.getConnection();
			}
		} catch (NamingException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private DBUtils(){}

}