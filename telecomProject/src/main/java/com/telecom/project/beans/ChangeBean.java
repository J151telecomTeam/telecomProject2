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
 * 操作日志bean
 * @author 
 *
 */
@Entity
@Table(name="t_change",catalog="telecom")
public class ChangeBean implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -877521529516238384L;
	
	@Id
	@Column(name="c_id")
	@GenericGenerator(name= "hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private long id; //主键
	
	@Column(name="c_change_time")
	private Date changeTime; // 操作时间
	
	@Column(name="c_name",length=20)
	private String name; //操作人员的姓名
	
	@Column(name="c_type",length=20)
	private String type; //操作类型
	
	@Column(name="c_description")
	private String description; //操作描述
	
	@Column(name="c_result",length=20)
	private String result; // 返回结果
	
	@Column(name="c_account",length=20)
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	
}
