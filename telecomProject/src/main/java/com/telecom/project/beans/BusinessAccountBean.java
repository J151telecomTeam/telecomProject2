package com.telecom.project.beans;

import java.io.Serializable;

/**
 * 业务账号bean
 * @author 
 *
 */
public class BusinessAccountBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6028656509951701092L;

	private long id; //主键
	
	private UserBean user; //账务bean/userbean
	
	private String osAccount; //os账号
	
	private String osPassword; //os密码
	
	private ServerBean server; //服务器bean
	
	private int status; //是否激活
	
	private int delete; // 是否删除
	
	private DealBean deal; //资费bean
	
	public BusinessAccountBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getOsAccount() {
		return osAccount;
	}

	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}

	public String getOsPassword() {
		return osPassword;
	}

	public void setOsPassword(String osPassword) {
		this.osPassword = osPassword;
	}

	public ServerBean getServer() {
		return server;
	}

	public void setServer(ServerBean server) {
		this.server = server;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public DealBean getDeal() {
		return deal;
	}

	public void setDeal(DealBean deal) {
		this.deal = deal;
	}

	@Override
	public String toString() {
		return "BusinessAccountBean [id=" + id + ", user=" + user + ", osAccount=" + osAccount + ", osPassword="
				+ osPassword + ", server=" + server + ", status=" + status + ", delete=" + delete + ", deal=" + deal
				+ "]";
	}
	
	
	
}
