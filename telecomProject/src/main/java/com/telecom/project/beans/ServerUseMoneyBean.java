package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务器使用费用明细bean
 * @author 
 *
 */
public class ServerUseMoneyBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -868516357029918361L;
	
	private long id; //主键
	
	private String ip; //服务器ip
	
	private String osAccount; //os账号
	
	private Date loginTime; //登陆时间
	
	private Date exitTime; //退出时间
	
	private long runTime; //使用时长（毫秒）
	
	private double price; //当次使用费用
	
	private DealBean deal; //资费bean
	
	public ServerUseMoneyBean() {
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

	public DealBean getDeal() {
		return deal;
	}

	public void setDeal(DealBean deal) {
		this.deal = deal;
	}

	@Override
	public String toString() {
		return "ServerUseMoneyBean [id=" + id + ", ip=" + ip + ", osAccount=" + osAccount + ", loginTime=" + loginTime
				+ ", exitTime=" + exitTime + ", runTime=" + runTime + ", price=" + price + ", deal=" + deal + "]";
	}
	
	

}
