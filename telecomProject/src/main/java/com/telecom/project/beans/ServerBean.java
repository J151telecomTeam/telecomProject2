package com.telecom.project.beans;

import java.io.Serializable;

/**
 * 服务器bean
 * @author 
 *
 */
public class ServerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4207885277456404389L;

	private long id; //主键
	 
	private String ip; //服务器ip
	
	private String name; //服务器名
	
	private String state; //状态
	
	private String maintain; //服务器状态
	
	public ServerBean() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMaintain() {
		return maintain;
	}

	public void setMaintain(String maintain) {
		this.maintain = maintain;
	}

	@Override
	public String toString() {
		return "ServerBean [id=" + id + ", ip=" + ip + ", name=" + name + ", state=" + state + ", maintain=" + maintain
				+ "]";
	}
	
	
	
}
