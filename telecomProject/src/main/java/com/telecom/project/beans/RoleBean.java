package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色bean
 * @author 
 *
 */
public class RoleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3127842160765796423L;
	
	private long id; //主键
	
	private String name; //角色名称
	
	private String founder; //创建人
	
	private Date createTime; //创建日期
	
	private String describe; //角色描述
	
	public RoleBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", name=" + name + ", founder=" + founder + ", createTime=" + createTime
				+ ", describe=" + describe + "]";
	}
	
	

}
