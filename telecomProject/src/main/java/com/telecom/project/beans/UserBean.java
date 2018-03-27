package com.telecom.project.beans;

import java.io.Serializable;

/**
 * 用户bean
 * @author 
 *
 */
public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1447065759998705891L;

	private long id;
	
	private String name; //姓名
	
	private String gender; //性别
	
	private String indentity; //身份证号
	
	private String password; //密码
	
	private String phone; //联系电话
	
	private String address; //通信地址
	
	private String postcode; //邮编
	
	private String qq; //QQ
	
	private String account; // 账务账号
	
	private String picture; //个人头像
	
	private int status; //是否激活
	
	private int delete; //是否删除
	
	public UserBean() {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIndentity() {
		return indentity;
	}

	public void setIndentity(String indentity) {
		this.indentity = indentity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", gender=" + gender + ", indentity=" + indentity
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", postcode=" + postcode
				+ ", qq=" + qq + ", account=" + account + ", picture=" + picture + ", status=" + status + ", delete="
				+ delete + "]";
	}
	
	
	
	
	
}
