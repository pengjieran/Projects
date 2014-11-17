package com.bean.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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
    public void query() throws SQLException {
	
	/**
	 *ArrayHandler：把结果集中的第一行数据转成对象数组。
	 *ArrayListHandler：把结果集中的每一行数据都转成一个对象数组，再存放到List中。
	 *BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
	 *BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
	 *ColumnListHandler：将结果集中某一列的数据存放到List中。
 	 *KeyedHandler：将结果集中的每一行数据都封装到一个Map里，然后再根据指定的key把每个Map再存放到一个Map里。
 	 *MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
 	 *MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List。
 	 *ScalarHandler：将结果集中某一条记录的其中某一列的数据存成Object。
	 */

	//采用MapHandler存储方式查询
	MapHandler handler = new MapHandler();
	QueryRunner runner = new QueryRunner();
	try {
	    
	    Map<String, Object> query = runner.query(connection,"select * from users where id = ?", handler, new Object[]{"5"});
	    System.out.println(query.get("name"));
	    
	} catch (SQLException e) {
	    
	    e.printStackTrace();
	}
	
	//采用MapListHandler存储方式查询
	MapListHandler mapListHandler = new MapListHandler();
	try {
	    
	    List<Map<String, Object>> query = runner.query(connection, "select * from users where id = ?", mapListHandler, new Object[]{"5"});
	    for (int i = 0; i < query.size(); i++) {
		
		Map<String, Object> map = query.get(i);
		System.out.println(map.get("name"));
	    }
	} catch (SQLException e) {
	    
	    e.printStackTrace();
	}
	
	//采用BeanHandler存储方式查询
	BeanHandler<Users> beanHandler = new BeanHandler<Users>(Users.class);
	Users users = runner.query(connection, "select * from users where id = ?", beanHandler, new Object[]{"5"});
	System.out.println(users.getName());
	
	//BeanListHandler存储方式查询
	BeanListHandler<Users> beanListHandler = new BeanListHandler<Users>(Users.class);
	List<Users> list = runner.query(connection, "select * from users where age > ?", beanListHandler, new Object[]{"1007"});
	for (Users user : list) {
	    
	    System.out.println(user.getAge());
	}
	
	//ArrayHandler存储方式查询,返回一个对象的值，有多个对象则只返第一个对象值
	ArrayHandler arrayHandler = new ArrayHandler();
	Object[] objects = runner.query(connection, "select * from users where age > ?", arrayHandler, new Object[]{"1005"});
	for (Object object : objects) {
	    
	    System.out.println(object.toString());
	}
	
	//ArrayListHandler存储方式查询
	ArrayListHandler arrayListHandler = new ArrayListHandler();
	List<Object[]> query = runner.query(connection, "select * from users where age > ?", arrayListHandler, new Object[]{"1005"});
	for (Object[] objects2 : query) {
	    
	    System.out.println(objects2[1].toString());
	}
	
	//ScalarHandler存储方式查询
	ScalarHandler<String> scalarHandler = new ScalarHandler<String>("name");
	String query2 = runner.query(connection, "select * from users where age > ?", scalarHandler, new Object[]{"1005"});
	System.out.println(query2);
	
	//KeyedHandler存储方式查询
	KeyedHandler<String> keyedHandler = new KeyedHandler<String>("name");
	Map<String, Map<String, Object>> map = runner.query(connection, "select * from users where age > ?", keyedHandler, new Object[]{"1005"});
	Map<String, Object> ob = map.get("users996");
	System.out.println(ob.get("name").toString());
    }
    
    @Test
    public void insert() {
	
    	//TODO update和insert都可以插入数据还是insert是另外的用途？
	QueryRunner runner = new QueryRunner();
	try {
	    
	    /*int update = runner.update(connection, "insert into users(name, age,sex) values(?,?,?)", new Object[]{"aaa", 250, "男"});
	    System.out.println(update);*/
	    
	    //不知为何这里做了插入，数据也放进去了，但是返回结果是空的
	    BeanHandler<Users> beanHandler = new BeanHandler<Users>(Users.class);
	    
	    Users user = runner.insert(connection, "insert into users(name, age,sex) values(?,?,?)", beanHandler, new Object[]{"aa", 25, "女"});
	    connection.commit();
	    System.out.println(user.getName());
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    //修改数据
    @Test
    public void update() {
    	
    	QueryRunner runner = new QueryRunner();
    	try {
    		
		int update = runner.update(connection, "update users set name = ?, age = ? where id = ?", new Object[]{"aaa","28","1"});
		//需要注意在初始化连接的时候是否允许自动提交
		connection.commit();
		System.out.println(update);
	} catch (SQLException e) {
			
		e.printStackTrace();
	}
	
    }
    
    @Test
    public void delete() {
    	
    	QueryRunner runner = new QueryRunner();
    	try {
    		
			int update = runner.update(connection, "delete from users where id = ?", new Object[]{"1"});
			connection.commit();
			System.out.println(update);
	} catch (SQLException e) {
			
	    e.printStackTrace();
	}
    	
    }
    
    @Before
    public void getInstance() throws SQLException {
	
	//加载数据库驱动
	DbUtils.loadDriver(DBDriver.MYSQL);
	//获取链接
	if (null == connection) {
	    
	    connection = DriverManager.getConnection(DBURL.getURL(DBType.MYSQL, "localhost", "3306", "testdb", DBURL.UTF8), user, password);
	}
	
	try {
	    
	    //关闭自动提交，以可以在发生错误时进行回滚操作
	    connection.setAutoCommit(false);
	} catch (SQLException e) {
	    
	    e.printStackTrace();
	}
    }
}