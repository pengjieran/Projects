package com.test;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * Guava中字符串工具类的使用
 * @author Aaron
 *
 */
public class StringTest {

	public static void main(String[] args) {
		System.out.println(outputSkipNull());
		List<String> splitterTest = SplitterTest();
		splitterTest.stream().forEach(str -> {
			System.out.println(str);
		});
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
	
	/**
	 * 	Splitter 拆分器，jdk原生的拆分器split会将尾部的分隔符丢弃
	 * 	JDK内建的字符串拆分工具有一些古怪的特性。比如，String.split悄悄丢弃了尾部的分隔符。 问题：”,a,,b,”.split(“,”)返回？
	 *	1.“”, “a”, “”, “b”, “”
	 *	2.null, “a”, null, “b”, null
	 *	3.“a”, null, “b”
	 *	4.“a”, “b”
	 *	5.以上都不对

	 *	正确答案是5：””, “a”, “”, “b”。只有尾部的空字符串被忽略了

	 * @return
	 */
	private static List<String> SplitterTest() {
		
		List<String> splitToList = Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.splitToList("foo,bar,,	qux");
		
		return splitToList;
	}
}