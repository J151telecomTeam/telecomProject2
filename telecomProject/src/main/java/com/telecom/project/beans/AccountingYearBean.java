package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 年账务明细bean  
 * @author 
 *
 */
@Entity
@Table(name="t_accounting_year",catalog="telecom")
public class AccountingYearBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3189368230425507837L;
	
	@Id
	@Column(name="a_id")
	@GenericGenerator(name="AccountingYear.id",strategy="identity")
	@GeneratedValue(generator="AccountingYear.id")
	private long id; //主键
	
	@Column(name="a_run_time")
	private long runTime; //年使用总时长
	
	@Column(name="a_os_account",length=20)
	private String osAccount; //os账号
	
	@Column(name="a_ip",length=20)
	private String ip; //服务器ip
	
	@Column(name="a_year",length=20)
	private String year; //年份
	
	@Column(name="a_zw_account",length=20)
	private String zwAccount; //账务账号
	
	public AccountingYearBean() {
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

	public String getZwAccount() {
		return zwAccount;
	}

	public void setZwAccount(String zwAccount) {
		this.zwAccount = zwAccount;
	}

	@Override
	public String toString() {
		return "AccountingYearBean [id=" + id + ", runTime=" + runTime + ", osAccount=" + osAccount + ", ip=" + ip
				+ ", year=" + year + ", zwAccount=" + zwAccount + "]";
	}
	
	

}
