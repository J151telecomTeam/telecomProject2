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
 * 登陆日志bean
 * @author 
 *
 */
@Entity
@Table(name="t_loginlog",catalog="telecom")
public class LoginLogBean implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1186962988776088911L;
	
	@Id
	@Column(name="l_id")
	@GenericGenerator(name= "hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private long id; //主键
	
	@Column(name="l_login_time")
	private Date loginTime; // 登陆时间
	
	@Column(name="l_out_time")
	private Date outTime; //退出时间
	
	@Column(name="l_name")
	private String name; //管理员名称
	
	@Column(name="l_login_ip",length=20)
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
