package com.sweepstakes.test;


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
		
		Double total = 200000D;
		Double suInteger = 119999D;
		
		Double a = suInteger/total;
		
		if (a.compareTo(0.6) >= 0)
		{
			System.out.println("相等");
		}
		System.out.println(a);
	}

}