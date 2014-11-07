package com.bena.test;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Test {

    public static void main(String[] args) {
	
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
	    
	    //查询出所有记录
	    DBCursor cursor = collection.find();
	    while (cursor.hasNext()) {
		
		DBObject dbObject = cursor.next();
		System.out.println(dbObject.toString());
		
	    }
	    
	} catch (UnknownHostException e) {
	    
	    e.printStackTrace();
	}
    }
}