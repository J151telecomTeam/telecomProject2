package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限管理bean
 * @author 
 *
 */
public class PowerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370222815460678639L;
	
	private long id; //主键
	
	private String name; //权限名称
	
	private String founder; //创建人
	
	private Date time; //创建时间
	
	private String describe; //权限描述
	
	private long fatherId; //父节点
	
	public PowerBean() {
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	@Override
	public String toString() {
		return "PowerBean [id=" + id + ", name=" + name + ", founder=" + founder + ", time=" + time + ", describe="
				+ describe + ", fatherId=" + fatherId + "]";
	}
	
	
	
	

}
