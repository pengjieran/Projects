package com.bean.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;

public class DBUtilsTest {
    
    @Test
    public void DBTest() {
	
	//加载数据库驱动
	boolean loadDriver = DbUtils.loadDriver("com.mysql.jdbc.Driver");
	
	
    }
}
