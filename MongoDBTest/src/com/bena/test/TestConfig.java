package com.bena.test;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * 
 * @author aaron
 *
 */
public class TestConfig {
    
    /**
     * 
     * @param host	数据库ip
     * @param port	端口号
     * @param dbName	数据库名
     * @param docName	文档名
     * @return	DBCollection
     * @throws UnknownHostException
     */
    public static DBCollection getCollection(String host, int port, String dbName, String docName) throws UnknownHostException {
	
	MongoClient client = new MongoClient(new ServerAddress(host, port));
	DB db = client.getDB(dbName);
	DBCollection collection = db.getCollection(docName);
	
	return collection;
    }
}