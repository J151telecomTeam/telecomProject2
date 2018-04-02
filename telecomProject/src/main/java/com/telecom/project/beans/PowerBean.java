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
 * 权限管理bean
 * @author 
 *
 */
@Entity
@Table(name="t_power",catalog="telecom")
public class PowerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370222815460678639L;
	

	@Id
	@Column(name="p_id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private long id; //主键
	
	@Column(name="p_name")
	private String name; //权限名称
	
	@Column(name="p_founder")
	private String founder; //创建人
	
	@Column(name="p_time")
	private Date time; //创建时间
	
	@Column(name="p_describe")
	private String describe; //权限描述
	
	@Column(name="p_father_id")
	private long fatherId; //父节点
	
	@Column(name="p_state")
	private int state;//是否被删除
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

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
				+ describe + ", fatherId=" + fatherId + ", state=" + state + "]";
	}

	
	
	
	

}
