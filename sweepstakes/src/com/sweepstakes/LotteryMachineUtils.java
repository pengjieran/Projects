package com.sweepstakes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *抽奖的部分逻辑，有些用户需要控制奖项何时加入奖池等操作，都可以在这里做
 * @author Aaron
 *
 */
public class LotteryMachineUtils {
	
	/**
	 * 传入奖项列表，传出幸运号，表示抽中了几等奖
	 * @param awards
	 * @return
	 */
	public static String getGoodsNo(List<Award> awards)
	{
		
		Integer total = 0;				//总量
		Integer surplusTotal = 0;		//余量
		
		//统计总量和余量，先将三等奖以下的加入奖池
		Map<String, Integer> goodsMap = new HashMap<String, Integer>();
		for (Award award : awards)
		{
			total += award.getCount();
			surplusTotal += award.getSurplus();
		}
		
		//完成量除以总量为百分率
		Double rate = (total.doubleValue() - surplusTotal.doubleValue())/total.doubleValue();
		/**
		 * 先将三等奖以下的加入，剩下的，完成量为总量的30%并且是三等奖的，加入奖池，完成量为总量的60%并且是二等奖的，加入奖池，完成量为总量的90%并且是一等奖的，加入奖池
		 */
		for (Award award : awards)
		{
			if (award.getSurplus() > 0)
			{
				
				if (award.getLevel() > 7)
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
				
				if (rate.compareTo(0.1) >= 0 && award.getLevel().equals(7))
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
				
				if (rate.compareTo(0.1) >= 0 && award.getLevel().equals(6))
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
				
				if (rate.compareTo(0.1) >= 0 && award.getLevel().equals(5))
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
				
				if (rate.compareTo(0.1) >= 0 && award.getLevel().equals(4))
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
				
				if (rate.compareTo(0.2) >= 0 && award.getLevel().equals(3))
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
				
				if (rate.compareTo(0.3) >= 0 && award.getLevel().equals(2))
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
				
				if (rate.compareTo(0.5) >= 0 && award.getLevel().equals(1))
				{
					goodsMap.put(award.getId(), award.getSurplus());
				}
			}
		}
		
		String lottery = LotteryMachine.doLottery(goodsMap);
		
		return lottery;
	}

	
	/**
	 * 不允许实例化，作为工具类
	 */
	private LotteryMachineUtils(){}
}