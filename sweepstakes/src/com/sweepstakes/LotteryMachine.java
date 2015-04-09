package com.sweepstakes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LotteryMachine {

	/**
	 * 抽奖机，key为指定的金额或编号，value为数量
	 * @param goodsMap
	 * @return
	 */
	public static int lottery(Map<Integer, Integer> goodsMap) {
		int goodsNo = 0;
		int sum = 0;
		Set<Map.Entry<Integer, Integer>> se = goodsMap.entrySet();
		for (Map.Entry<Integer, Integer> me : se) {
			sum += me.getValue();
		}
		int b = getRandom(sum);
		int pre = 0;
		int cur = 0;
		for (Map.Entry<Integer, Integer> me : se) {
			cur = me.getValue();
			if (pre <= b && b < cur + pre) {
				goodsNo = me.getKey();
				break;
			} else {
				pre += cur;
			}
		}
		return goodsNo;
	}

	/**
	 * 抽奖机，奖品代号为字符串，value为数量
	 * @param goodsMap
	 * @return
	 */
	public static String doLottery(Map<String, Integer> goodsMap) {
		String goodsNo = null;
		int sum = 0;
		Set<Map.Entry<String, Integer>> se = goodsMap.entrySet();
		for (Map.Entry<String, Integer> me : se) {
			sum += me.getValue();
		}
		int b = getRandom(sum);
		int pre = 0;
		int cur = 0;
		for (Map.Entry<String, Integer> me : se) {
			cur = me.getValue();
			if (pre <= b && b < cur + pre) {
				goodsNo = me.getKey();
				break;
			} else {
				pre += cur;
			}
		}
		return goodsNo;
	}

	public static int getRandom(int num) {
		int b = (int) (Math.random() * (num));
		return b;
	}

	public static void main(String[] args) {
		/*
		 * List<String> il = new LinkedList<String>(); il.add("list");
		 * il.add("map"); il.add("common"); il.add("common"); il.add("linux");
		 * for(int i = 0; i < il.size(); i++) { System.out.println(i + "=>" +
		 * il.get(i)); } il.remove(1); for(int i = 0; i < il.size(); i++) {
		 * System.out.println(i + "=>" + il.get(i)); }
		 */

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		File file = new File("result");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter filewriter = null;
		try {
			filewriter = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		map.put(1, 60000);
		map.put(2, 30000);
		map.put(5, 10000);
		int sum = 0;
		for (int i = 0; i < 100000; i++) {

			int lottery = lottery(map);
			System.out.println(i + ":" + lottery);

			int a = map.get(lottery);
			a = a - 1;
			map.replace(lottery, a);
			System.out.println(lottery + "余量：" + a);
			try {
				filewriter.write(lottery + "余量：" + a + "----");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum  = sum + lottery;
		}
		System.out.println(sum);

	}

}