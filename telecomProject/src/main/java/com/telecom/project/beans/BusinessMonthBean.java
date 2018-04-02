package com.telecom.project.beans;

import java.io.Serializable;


/**
 * 月业务账单bean
 * @author 
 *
 */
public class BusinessMonthBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2161340063821506894L;
	
	private long id; //主键
	
	private String osAccount; //os账号
	
	private String ip; //服务器IP
	
	private long runTime; //使用时长
	
	private double price; //月费用
	
	private DealBean deal; //资费bean
	
	
	private String zwAccount; // 账务账号
	
	public BusinessMonthBean() {
		// TODO Auto-generated constructor stub
	}

	
	
	public String getZwAccount() {
		return zwAccount;
	}

	public void setZwAccount(String zwAccount) {
		this.zwAccount = zwAccount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOsAccount() {
		return osAccount;
	}

	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getRunTime() {
		return runTime;
	}

	public void setRunTime(long runTime) {
		this.runTime = runTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public DealBean getDeal() {
		return deal;
	}



	public void setDeal(DealBean deal) {
		this.deal = deal;
	}



	@Override
	public String toString() {
		return "BusinessMonthBean [id=" + id + ", osAccount=" + osAccount + ", ip=" + ip + ", runTime=" + runTime
				+ ", price=" + price + ", deal=" + deal + ", zwAccount=" + zwAccount + "]";
	}
	
	
	
	

}
