package com.bean.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * 测试commons.io包的测试类
 * @author aaron
 *
 */
public class IOUtilsTest {
    
    //获取文件路径的方法
    @Test
    public void getPath() {
	
	File file = new File("");//指代当前路径,.表示当前文件夹，..表示当前文件夹的上一个文件夹
	System.out.println(file.getAbsolutePath());	//获取绝对路径
	try {
	    
	    System.out.println(file.getCanonicalPath());//获取绝对路径
	} catch (IOException e) {
	    
	    e.printStackTrace();
	}
	
	System.out.println(file.getPath());

    }
    
    @Test
    public void test() {
	
	File file = new File("");
	String absolutePath = file.getAbsolutePath();
	String filePath = absolutePath + "\\src\\com\\bean\\io\\test\\test1\\test2\\sbt.txt";
	System.out.println(absolutePath);
	long size = FileUtils.sizeOf(new File(absolutePath + "\\src\\com\\bean\\io\\test\\test1\\test2\\sbt.txt"));
	System.out.println(absolutePath + "\\src\\com\\bean\\io\\test");
	System.out.println(size);
    }

}
