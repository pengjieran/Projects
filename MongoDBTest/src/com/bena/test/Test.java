package com.bena.test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Test {

    public static void main(String[] args) {
	
	String host = "localhost";
	int port = 27017;
	String dbName = "MongoDBTest";
	String docName = "user";
	
	try {
	    
	    DBCollection collection = TestConfig.getCollection(host, port, dbName, docName);
	   
	    for (int i = 0; i < 100; i++) {
		
		BasicDBObject object = new BasicDBObject("name", "user" + i).append("age", i).append("sex", i/2 == 0 ? "男" : "女");
		collection.insert(object);
	    }
	    
	    System.out.println(collection.find().count());
	    collection.drop();
	    
	} catch (UnknownHostException e) {
	    
	    e.printStackTrace();
	}
    }
}