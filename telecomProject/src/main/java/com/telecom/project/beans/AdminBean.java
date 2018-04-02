package com.telecom.project.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 管理员bean
 * @author 
 *
 */
@Entity
@Table(name="t_admin",catalog="telecom")
public class AdminBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7428123140225478115L;

	
	@Id
	@Column(name="a_id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private long id; //主键
	
	@Column(name="a_name",length=20)
	private String name; //管理员姓名
	
	@Column(name="a_account",length=20)
	private String account; //管理员账号
	
	@Column(name="a_password",length=32)
	private String password; //密码
	
	@Column(name="a_tel",length=20)
	private String tel; //联系电话
	
	@Column(name="a_mail",length=20)
	private String mail; //邮箱
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.REFRESH})
	@JoinColumn(name="a_r_id")
	private RoleBean role; // 角色bean
	
	
	
	public AdminBean() {
		// TODO Auto-generated constructor stub
	}



	public AdminBean(String name, String account, String password, String tel, String mail, RoleBean role) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.tel = tel;
		this.mail = mail;
		this.role = role;
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
