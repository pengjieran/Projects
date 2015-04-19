package com.sweepstakes;

import java.util.UUID;

/**
 * 奖项设置，有些公司可能会要求某些奖项暂时不加入奖池，达到某一些条件以后才会允许加入奖池
 * @author Aaron
 *
 */
public class Award {
	
	private String id;
	
	private String name;
	
	private Integer level;
	
	private Integer count;
	
	private Integer surplus;

	public Award() {
		super();
		UUID randomUUID = UUID.randomUUID();
		String uuid = randomUUID.toString();
		this.id = uuid.replaceAll("-", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSurplus() {
		return surplus;
	}

	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}

}