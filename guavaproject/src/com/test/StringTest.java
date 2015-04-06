package com.test;

import com.google.common.base.Joiner;

/**
 * Guava中字符串工具类的使用
 * @author Aaron
 *
 */
public class StringTest {

	public static void main(String[] args) {
		System.out.println(outputSkipNull());
	}
	
	/**
	 * 连接器Joiner，skipNulls 在拼接字符串时会跳过null值
	 * @return String
	 */
	private static String outputSkipNull() {
		
		Joiner joiner = Joiner.on(";").skipNulls();
		String join = joiner.join("Aaron", null, "and", "Dean");
		return join;
	}
}