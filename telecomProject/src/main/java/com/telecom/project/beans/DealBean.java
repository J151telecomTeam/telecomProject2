package com.telecom.project.beans;

import java.io.Serializable;

/**
 * 资费bean
 * @author 
 *
 */
public class DealBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6185355376965343112L;

	private long id; //主键
	
	private String name; //资费名称
	
	private int type; //资费类型
	
	private int duration; //基本时长
	
	private double cost; //基本费用
	
	private double money; //单位费用
	
	private String msg; //资费说明
	
	public DealBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "DealBean [id=" + id + ", name=" + name + ", type=" + type + ", duration=" + duration + ", cost=" + cost
				+ ", money=" + money + ", msg=" + msg + "]";
	}
	
	
	
}
