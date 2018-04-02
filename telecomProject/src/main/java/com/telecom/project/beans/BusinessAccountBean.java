package com.telecom.project.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 业务账号bean
 * @author 
 *
 */
@Entity
@Table(name="t_service_account",catalog="telecom")
public class BusinessAccountBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6028656509951701092L;

	@Id
	@Column(name="s_id")
	@GenericGenerator(name="business.id",strategy="identity")
	@GeneratedValue(generator="business.id")
	private long id; //主键
	
	@OneToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE,CascadeType.REFRESH})
	@JoinColumn(name="s_u_id")
	private UserBean user; //账务bean/userbean
	
	@Column(name="s_osaccount",length=20)
	private String osAccount; //os账号
	
	@Column(name="s_ospassword",length=20)
	private String osPassword; //os密码
	
	@OneToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE,CascadeType.REFRESH})
	@JoinColumn(name="s_s_id")
	private ServerBean server; //服务器bean
	
	@Column(name="s_status")
	private int status; //是否激活
	
	@Column(name="s_delete")
	private int delete; // 是否删除
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.ALL})
	@JoinColumn(name="s_d_id")
	private DealBean deal; //资费bean
	
	public BusinessAccountBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getOsAccount() {
		return osAccount;
	}

	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}

	public String getOsPassword() {
		return osPassword;
	}

	public void setOsPassword(String osPassword) {
		this.osPassword = osPassword;
	}

	public ServerBean getServer() {
		return server;
	}

	public void setServer(ServerBean server) {
		this.server = server;
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

	public DealBean getDeal() {
		return deal;
	}

	public void setDeal(DealBean deal) {
		this.deal = deal;
	}

	@Override
	public String toString() {
		return "BusinessAccountBean [id=" + id + ", user=" + user + ", osAccount=" + osAccount + ", osPassword="
				+ osPassword + ", server=" + server + ", status=" + status + ", delete=" + delete + ", deal=" + deal
				+ "]";
	}
	
	
	
}
