package com.bena.test;

import java.net.UnknownHostException;

import org.junit.Before;

import com.mongodb.DBCollection;

public class Test {
    
    private DBCollection collection;
    
    @Before
    public void init() {
	
	try {
	    
	    collection = TestConfig.getCollection("localhost", 27017, "MongoDBTest", "user");
	} catch (UnknownHostException e) {
	    
	    e.printStackTrace();
	}
    }

    /*public static void main(String[] args) {
	
	String host = "localhost";
	int port = 27017;
	String dbName = "MongoDBTest";
	String docName = "user";
	
	try {
	    
	    DBCollection collection = TestConfig.getCollection(host, port, dbName, docName);
	   
	    //插入一百条测试数据
	    for (int i = 0; i < 100; i++) {
		
		BasicDBObject object = new BasicDBObject("name", "user" + i).append("age", i).append("sex", i/2 == 0 ? "男" : "女");
		collection.insert(object);
	    }
	    
	    System.out.println(collection.find().count());
	    //删除表
	    //collection.drop();
	    
	    //查询出第一条记录
	    DBObject object = collection.findOne();
	    System.out.println(object.toString());
	    
	    //查询出所有记录,显示每条记录
	    DBCursor cursor = collection.find();
	    while (cursor.hasNext()) {
		
		DBObject dbObject = cursor.next();
		System.out.println(dbObject.toString());
	    }
	    
	    //查询当前文档数据的记录总数
	    long count = collection.count();
	    System.out.println(count);
	    
	    //获取当前查询的总记录数
	    long total = collection.count(cursor.getQuery());
	    System.out.println(total);
	    
	    //按照用户名等于user1查询
	    DBCursor dbCursor = collection.find(new BasicDBObject("name", "user1"));
	    while (dbCursor.hasNext()) {
		
		System.out.println(dbCursor.next().toString());
	    }
	    
	    dbCursor = collection.find(new BasicDBObject("age", "$gt 22"));
	    while (dbCursor.hasNext()) {
		
		System.out.println(dbCursor.next().toString());
	    }
	    
	    
	    
	} catch (UnknownHostException e) {
	    
	    e.printStackTrace();
	}
    }*/
    
    @org.junit.Test
    public void query() {
	
	long count = collection.getCount();
	System.out.println(count);
	
    }
}