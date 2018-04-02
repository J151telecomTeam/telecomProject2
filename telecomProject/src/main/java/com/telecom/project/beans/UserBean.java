package com.telecom.project.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 用户bean
 * @author 
 *
 */

@Entity
@Table(name="t_user",catalog="telecom")
public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1447065759998705891L;
	
	@Id
	@Column(name="u_id")
	@GenericGenerator(name="user.id",strategy="identity")
	@GeneratedValue(generator="user.id")
	private long id;
	
	@Column(name="u_name",length=20)
	private String name; //姓名
	
	@Column(name="u_gender",length=10)
	private String gender; //性别
	
	@Column(name="u_indentity",length=20)
	private String indentity; //身份证号
	
	@Column(name="u_password",length=32)
	private String password; //密码
	
	@Column(name="u_phone",length=20)
	private String phone; //联系电话
	
	@Column(name="u_address",length=32)
	private String address; //通信地址
	
	@Column(name="u_postcode",length=32)
	private String postcode; //邮编
	
	@Column(name="u_qq",length=20)
	private String qq; //QQ
	
	@Column(name="u_account",length=32)
	private String account; // 账务账号
	
	@Column(name="u_picture")
	private String picture; //个人头像
	
	@Column(name="u_status",length=20)
	private String status; //是否激活
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	@Cascade(value= {CascadeType.ALL})
	private List<BusinessAccountBean> businessaccount;
	
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public List<BusinessAccountBean> getBusinessaccount() {
		return businessaccount;
	}

	public void setBusinessaccount(List<BusinessAccountBean> businessaccount) {
		this.businessaccount = businessaccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", gender=" + gender + ", indentity=" + indentity
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", postcode=" + postcode
				+ ", qq=" + qq + ", account=" + account + ", picture=" + picture + ", status=" + status + "]";
	}

	
	

	
	
	
	
	
}
