package com.bean.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import com.bean.dbutils.DBURL.DBType;

public class DBUtilsTest {
    
    private static final String user = "root";
    
    private static final String password = "root";
    
    private static Connection connection;
    
    @Test
    public void DBTest() {
	
	try {
	    
	    BeanListHandler<Users> beanListHandler = new BeanListHandler<Users>(Users.class);
	    QueryRunner queryRunner = new QueryRunner();
	    List<Users> userList = queryRunner.query(connection, "select * from users", beanListHandler);
	    
	    for (Users user : userList) {
		
		System.out.println(user.toString());
	    }
	    DbUtils.close(connection);
	} catch (SQLException e) {
	    
	    e.printStackTrace();
	}
	
    }
    
    @Test
    public void query() {
	
	
    }
    
    @Test
    public void insert() {
	
	
    }
    
    @Test
    public void update() {
	
	
    }
    
    @Test
    public void delete() {
	
	
    }
    
    @Before
    public void getInstance() throws SQLException {
	
	//加载数据库驱动
	DbUtils.loadDriver(DBDriver.MYSQL);
	//获取链接
	if (null == connection) {
	    
	    connection = DriverManager.getConnection(DBURL.getURL(DBType.MYSQL, "localhost", "3306", "testdb", DBURL.UTF8), user, password);
	}
	
    }
}