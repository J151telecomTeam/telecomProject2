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
 * 服务记录bean
 * @author 
 *
 */
@Entity
@Table(name="t_server_use_money",catalog="telecom")
public class ServiceRecordBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -443456758519122398L;

	
	@Id
	@Column(name="s_id")
	@GenericGenerator(name="server_use_money.id",strategy="identity")
	@GeneratedValue(generator="server_use_money.id")
	private long id;// 主键
	
	@Column(name="s_os_account",length=20)
	private String osAccount; //os账号
	
	@Column(name="s_ip",length=30)
	private String ip; //服务器ip
	
	@Column(name="s_login_time")
	private Date startTime; //开始时间
	
	@Column(name="s_exit_time")
	private Date exitTime; //结束时间
	
	@Column(name="s_run_time")
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
