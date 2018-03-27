package com.telecom.project.beans;

import java.io.Serializable;

/**
 * 管理员bean
 * @author 
 *
 */
public class AdminBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7428123140225478115L;

	private long id; //主键
	
	private String name; //管理员姓名
	
	private String account; //管理员账号
	
	private String password; //密码
	
	private String tel; //联系电话
	
	private String mail; //邮箱
	
	private RoleBean role; // 角色bean
	
	public AdminBean() {
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AdminBean [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", tel="
				+ tel + ", mail=" + mail + ", role=" + role + "]";
	}
	
	
	
}
