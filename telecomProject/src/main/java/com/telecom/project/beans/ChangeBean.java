package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志bean
 * @author 
 *
 */
public class ChangeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -877521529516238384L;
	
	private long id; //主键
	
	private Date changeTime; // 操作时间
	
	private String name; //操作人员的姓名
	
	private String type; //操作类型
	
	private String description; //操作描述
	
	private int result; // 返回结果
	
	private String account; //操作人员的账号
	
	public ChangeBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "ChangeBean [id=" + id + ", changeTime=" + changeTime + ", name=" + name + ", type=" + type
				+ ", description=" + description + ", result=" + result + ", account=" + account + "]";
	}
	
	

}
