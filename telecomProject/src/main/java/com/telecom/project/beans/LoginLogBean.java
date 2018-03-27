package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 登陆日志bean
 * @author 
 *
 */
public class LoginLogBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1186962988776088911L;
	
	private long id; //主键
	
	private Date loginTime; // 登陆时间
	
	private Date outTime; //退出时间
	
	private String name; //管理员名称
	
	private String loginIp; //用户登陆时的ip地址
	
	public LoginLogBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Override
	public String toString() {
		return "LoginLogBean [id=" + id + ", loginTime=" + loginTime + ", outTime=" + outTime + ", name=" + name
				+ ", loginIp=" + loginIp + "]";
	}
	
	

}
