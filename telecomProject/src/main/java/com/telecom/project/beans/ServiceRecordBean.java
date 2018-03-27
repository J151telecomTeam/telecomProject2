package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务记录bean
 * @author 
 *
 */
public class ServiceRecordBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -443456758519122398L;

	private long id;// 主键
	
	private String osAccount; //os账号
	
	private String ip; //服务器ip
	
	private Date startTime; //开始时间
	
	private Date exitTime; //结束时间
	
	private long runTime; //总运行时间
	
	public ServiceRecordBean() {
		// TODO Auto-generated constructor stub
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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

	@Override
	public String toString() {
		return "ServiceRecordBean [id=" + id + ", osAccount=" + osAccount + ", ip=" + ip + ", startTime=" + startTime
				+ ", exitTime=" + exitTime + ", runTime=" + runTime + "]";
	}
	
	
	
}
