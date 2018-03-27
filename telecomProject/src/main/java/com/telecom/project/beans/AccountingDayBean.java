package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 日账务明细bean
 * @author 
 *
 */
public class AccountingDayBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3774422648727935616L;
	
	private long id; //主键
	
	private long runTime; //当日使用总时长
	
	private String osAccount; //os账号
	
	private String ip; //服务器ip
	
	private Date year; //年份
	
	private Date month; //月份
	
	private Date day; //日期
	
	private String zwAccount; //账务账号
	
	public AccountingDayBean() {
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

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getZwAccount() {
		return zwAccount;
	}

	public void setZwAccount(String zwAccount) {
		this.zwAccount = zwAccount;
	}

	@Override
	public String toString() {
		return "AccountingDayBean [id=" + id + ", runTime=" + runTime + ", osAccount=" + osAccount + ", ip=" + ip
				+ ", year=" + year + ", month=" + month + ", day=" + day + ", zwAccount=" + zwAccount + "]";
	}
	
	

}
