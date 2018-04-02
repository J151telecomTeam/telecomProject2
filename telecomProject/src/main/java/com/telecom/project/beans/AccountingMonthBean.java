package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 月账务明细bean
 * @author 
 *
 */
public class AccountingMonthBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6232671958688792595L;

	private long id; //主键
	
	private long runTime; // 当月使用总时长
	
	private String osAccount; //os账号
	
	private String ip; //服务器ip
	
	private String year; //年份
	
	private String month; //月份
	
	private String zwAccount; //账务账号
	
	public AccountingMonthBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRunTime() {
		return runTime;
	}

	public void setRunTime(long runTime) {
		this.runTime = runTime;
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

	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getZwAccount() {
		return zwAccount;
	}

	public void setZwAccount(String zwAccount) {
		this.zwAccount = zwAccount;
	}

	@Override
	public String toString() {
		return "AccountingMonthBean [id=" + id + ", runTime=" + runTime + ", osAccount=" + osAccount + ", ip=" + ip
				+ ", year=" + year + ", month=" + month + ", zwAccount=" + zwAccount + "]";
	}
	
	
	
}
