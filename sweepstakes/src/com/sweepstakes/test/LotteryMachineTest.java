package com.sweepstakes.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sweepstakes.Award;
import com.sweepstakes.LotteryMachineUtils;


public class LotteryMachineTest {
	
	public static void main(String[] args) {
		
		/*for (int i = 0; i < 10000; i++)
		{
			
			UUID randomUUID = UUID.randomUUID();
			String all = randomUUID.toString().replaceAll("-", "");
			System.out.println(randomUUID.toString());
			System.out.println(all);
			try {
				Thread.sleep(1L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
		/*Double total = 200000D;
		Double suInteger = 119999D;
		
		Double a = suInteger/total;
		
		if (a.compareTo(0.6) >= 0)
		{
			System.out.println("相等");
		}
		System.out.println(a);*/
		
		List<Award> awards = new ArrayList<Award>();
		Award award1 = new Award();
		award1.setLevel(1);
		award1.setCount(1);
		award1.setName("一等奖");
		award1.setSurplus(1);
		awards.add(award1);
		
		Award award2 = new Award();
		award2.setLevel(2);
		award2.setCount(2);
		award2.setName("二等奖");
		award2.setSurplus(2);
		awards.add(award2);
		
		Award award3 = new Award();
		award3.setLevel(3);
		award3.setCount(3);
		award3.setName("三等奖");
		award3.setSurplus(3);
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
		award6.setCount(1000);
		award6.setName("六等奖");
		award6.setSurplus(1000);
		awards.add(award6);
		
		Award award7 = new Award();
		award7.setLevel(7);
		award7.setCount(1500);
		award7.setName("七等奖");
		award7.setSurplus(1500);
		awards.add(award7);
		
		Award award8 = new Award();
		award8.setLevel(8);
		award8.setCount(146894);
		award8.setName("未中奖");
		award8.setSurplus(146894);
		awards.add(award8);
		
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
			e1.printStackTrace();
		}
		
		for (int i = 0; i < 150000; i++) {

			String lottery = LotteryMachineUtils.getGoodsNo(awards);
			
			for (Award award : awards)
			{
				if (lottery.equals(award.getId()))
				{
					award.setSurplus(award.getSurplus() - 1);
					try {
						filewriter.write(award.getName() + "--余量：" + award.getSurplus() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("" + award.getName());
					break;
				}
			}
		}
		
	}

}