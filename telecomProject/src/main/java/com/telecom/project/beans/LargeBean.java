package com.telecom.project.beans;

import java.io.Serializable;

/**
 * 组合Bean 创建于2108-03-30
 * @author Administrator
 *
 */
public class LargeBean implements Serializable{

	private Long id;
	private String ServerName;//服务器名称
	private int state;     //缴费状态
	private String maintain;//服务器状态
	private int type; //资费模式
	
	public LargeBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LargeBean [id=" + id + ", ServerName=" + ServerName + ", state=" + state + ", maintain=" + maintain
				+ ", type=" + type + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServerName() {
		return ServerName;
	}

	public void setServerName(String serverName) {
		ServerName = serverName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMaintain() {
		return maintain;
	}

	public void setMaintain(String maintain) {
		this.maintain = maintain;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
