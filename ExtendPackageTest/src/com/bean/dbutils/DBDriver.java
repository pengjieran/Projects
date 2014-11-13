package com.bean.dbutils;

/**
 * 数据库配置类，所有的配置选项都应该从这里获取
 * @author aaron
 *
 */
public class DBDriver {
    
    protected static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";

    protected static final String ORACLEDRIVER = "oracle.jdbc.driver.OracleDriver";

    protected static final String SQLSERVERDRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";

    protected static final String DB2DRIVER = "com.ibm.db2.jdbc.app.DB2Driver";

    protected static final String SYBASEDRIVER = "com.sybase.jdbc.SybDriver";

    protected static final String POSTGRESQLDRIVER = "org.postgresql.Driver";

    protected static final String INFORMIXDRIVER = "com.informix.jdbc.IfxDriver";
    
    //不允许实例化
    private DBDriver(){}

}