package com.sweepstakes.test;

import java.util.UUID;

public class LotteryMachineTest {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10000; i++)
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
		}
		
		
	}

}