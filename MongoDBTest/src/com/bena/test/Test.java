package com.bena.test;

import java.net.UnknownHostException;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Before;

import com.mongodb.BasicDBObject;
import com.mongodb.Bytes;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

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
	
	//查询记录总数
	long count = collection.getCount();
	System.out.println(count);
	
	//查询所有
	DBCursor cursor = collection.find();
	System.out.println(cursor.length());
	
	//模糊查询
	String str = "haha";
	DBCursor find4 = collection.find(new BasicDBObject("name", Pattern.compile("^.*" + str + ".*$", Pattern.CASE_INSENSITIVE)));
	System.out.println("模糊查询结果：" + find4.size());

	//查询出年龄等于24的数据
	cursor = collection.find(new BasicDBObject("age", 24));
	List<DBObject> array = cursor.toArray();
	System.out.println(array.size());
	
	//查询年龄大于等于24的人的信息
	List<DBObject> list = collection.find(new BasicDBObject("age", new BasicDBObject("$gte", 24))).toArray();
	System.out.println("年龄大于24岁的：" + list.toString());
	System.out.println(list.size());
	
	//查询年龄小于等于25
	DBCursor dbCursor = collection.find(new BasicDBObject("age", new BasicDBObject("$lte", 25)));
	/*while (dbCursor.hasNext()) {
	    
	    System.out.println(dbCursor.next());
	}*/
	
	//查询年龄不等于25
	DBCursor find = collection.find(new BasicDBObject("age", new BasicDBObject("$ne", 25)));
	System.out.println(find.size());
	
	//查询年龄在一定范围内的数据
	DBCursor find2 = collection.find(new BasicDBObject("age", new BasicDBObject(QueryOperators.IN, new int[]{25, 26, 27})));
	System.out.println(find2.count());
	
	//查询年龄不再一定范围内的数据
	DBCursor find3 = collection.find(new BasicDBObject("age", new BasicDBObject(QueryOperators.NIN, new int[]{25, 26, 27})));
	System.out.println(find3.size());
	
	//查询排序
	DBCursor find5 = collection.find(new BasicDBObject("age", new BasicDBObject(QueryOperators.EXISTS, true)));
	System.out.println(find5.size());
	
	System.out.println("只查询age属性：" + collection.find(null, new BasicDBObject("age", true)).toArray());
	

    }
}