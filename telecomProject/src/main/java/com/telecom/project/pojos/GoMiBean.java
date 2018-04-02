package com.telecom.project.pojos;

import java.io.Serializable;
import java.util.Date;

public class GoMiBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6613645655230736825L;

	private long id; // 主键

	private String ip; // 服务器ip

	private String osAccount; // os账号

	private Date loginTime; // 登陆时间

	private Date exitTime; // 退出时间

	private long runTime; // 使用时长（毫秒）

	private double price; // 当次使用费用

	private int deal;
	
	public GoMiBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOsAccount() {
		return osAccount;
	}

	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
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

	public int getDeal() {
		return deal;
	}

	public void setDeal(int deal) {
		this.deal = deal;
	}

	@Override
	public String toString() {
		return "GoMiBean [id=" + id + ", ip=" + ip + ", osAccount=" + osAccount + ", loginTime=" + loginTime
				+ ", exitTime=" + exitTime + ", runTime=" + runTime + ", price=" + price + ", deal=" + deal + "]";
	}
	
	

}
