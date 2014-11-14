package com.bean.dbutils;

/**
 * 数据库配置类，所有的配置选项都应该从这里获取
 * @author aaron
 *
 */
public class DBDriver {
    
    protected static final String MYSQL = "com.mysql.jdbc.Driver";

    protected static final String ORACLE = "oracle.jdbc.driver.OracleDriver";

    protected static final String SQLSERVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";

    protected static final String DB2 = "com.ibm.db2.jdbc.app.DB2Driver";

    protected static final String SYBASE = "com.sybase.jdbc.SybDriver";

    protected static final String POSTGRESQL = "org.postgresql.Driver";

    protected static final String INFORMIX = "com.informix.jdbc.IfxDriver";
    
    //不允许实例化
    private DBDriver(){}

}