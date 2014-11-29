WebExample
========

	用于学习Servlet的项目，温故而知新，不想在学新东西的时候忘了旧东西
	
	jboss中配置数据源：
	1,在jboss_home/modules目录下新建目录，com\mysql\main，在该文件夹下新建xml文件module.xml,文件名不能改，路径可以不一样，写上如下配置：
	<?xml version="1.0" encoding="UTF-8"?>  
	<module xmlns="urn:jboss:module:1.1" name="com.mysql">  
	    <resources>  
	        <resource-root path="mysql-connector-java-5.1.34-bin.jar"/>  
	    </resources>  
	    <dependencies>  
	        <module name="javax.api"/>  
	        <module name="javax.transaction.api"/>  
	    </dependencies>  
	</module> 
	同一个文件夹下也必须要有mysql-connector-java-5.1.34-bin.jar文件
	
	2，standalone.xml文件中的配置：
		drivers节点中加入如下配置：
			<driver name="mysql" module="com.mysql">
            	<driver-class>com.mysql.jdbc.Driver</driver-class>        				<xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
            </driver>
         <driver-class>这个配置缺了就不能工作了，具体原因不知道。
         datasources节点下加入如下配置：
         <datasource jndi-name="java:jboss/datasources/mysqlDS" pool-name="mysqlDSPool" enabled="true" use-java-context="true">    
                    			<connection-url>jdbc:mysql://localhost:3306/testdb</connection-url>    
            <driver>mysql</driver>    
            <security>    
                <user-name>root</user-name>    
                <password>root</password>    
            </security>    
         </datasource>
         
         
    该系统会变成一个完整的系统，包含增删改查和其它的一些功能,
    重新设计其功能，先想好有哪些需要增加的功能

    Dean
    jierancto@163.com
