package com.sweepstakes.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sweepstakes.Award;
import com.sweepstakes.LotteryMachine;
import com.sweepstakes.LotteryMachineUtils;

public class LotteryTest {

	public static void main(String[] args) {
		
		List<Award> awards = new ArrayList<Award>();
		Award award1 = new Award();
		award1.setLevel(1);
		award1.setCount(1);
		award1.setName("一等奖");
		award1.setSurplus(1);
		awards.add(award1);
		
		Award award2 = new Award();
		award2.setLevel(2);
		award2.setCount(5);
		award2.setName("二等奖");
		award2.setSurplus(5);
		awards.add(award2);
		
		Award award3 = new Award();
		award3.setLevel(3);
		award3.setCount(10);
		award3.setName("三等奖");
		award3.setSurplus(10);
		awards.add(award3);
		
		Award award4 = new Award();
		award4.setLevel(4);
		award4.setCount(100);
		award4.setName("四等奖");
		award4.setSurplus(100);
		awards.add(award4);
		
		Award award5 = new Award();
		award5.setLevel(5);
		award5.setCount(500);
		award5.setName("五等奖");
		award5.setSurplus(500);
		awards.add(award5);
		
		Award award6 = new Award();
		award6.setLevel(6);
		award6.setCount(1500);
		award6.setName("六等奖");
		award6.setSurplus(1500);
		awards.add(award6);
		
		Award award7 = new Award();
		award7.setLevel(7);
		award7.setCount(147884);
		award7.setName("空奖");
		award7.setSurplus(147884);
		awards.add(award7);
		String one = "";
		String two = "";
		String three = "";
		for (int i = 0; i < 150000; i++)
		{
			Map<String, Integer> goodNo = LotteryMachineUtils.getGoodNo(awards, 3);
			Set<Entry<String,Integer>> entrySet = goodNo.entrySet();
			int surplus = 0;
			for (Entry<String, Integer> entry : entrySet)
			{
				surplus += entry.getValue();
			}
			String lottery = LotteryMachine.doLottery(goodNo);
			if (lottery == null)
			{
				System.out.println("无奖");
				continue;
			}
			for (Award award : awards)
			{
				if (lottery.equals(award.getId()))
				{
					awards.remove(award);
					award.setSurplus(award.getSurplus() - 1);
					awards.add(award);
					System.out.println("" + award.getName());
					System.out.println("余量:" + surplus);
					if (award.getLevel() == 1)
					{
						one += "一等奖出现在：" + i +"次抽奖中,";
					}
					if (award.getLevel() == 2)
					{
						two += "二等奖出现在：" + i +"次抽奖中,";
					}
					if (award.getLevel() == 3)
					{
						three += "三等奖出现在：" + i +"次抽奖中,";
					}
					break;
				}
			}
		}
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);

	}

}
