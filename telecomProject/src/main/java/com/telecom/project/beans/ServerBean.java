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
 * 服务器bean
 * @author 
 *
 */
@Entity
@Table(name="t_service",catalog="telecom")
public class ServerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4207885277456404389L;
	@Id
	@Column(name="s_id")
	@GenericGenerator(name="user.id",strategy="identity")
	@GeneratedValue(generator="user.id")
	private long id; //主键
	 
	@Column(name="s_ip")
	private String ip; //服务器ip
	
	@Column(name="s_name")
	private String name; //服务器名
	
	@Column(name="s_state")
	private String state; //状态
	
	@Column(name="s_maintain")
	private String maintain; //服务器状态
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="server")
	@Cascade(value= {CascadeType.ALL})
	private List<BusinessAccountBean> businessaccount;
	
	public ServerBean() {
		// TODO Auto-generated constructor stub
	}

	
	public List<BusinessAccountBean> getBusinessaccount() {
		return businessaccount;
	}


	public void setBusinessaccount(List<BusinessAccountBean> businessaccount) {
		this.businessaccount = businessaccount;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMaintain() {
		return maintain;
	}

	public void setMaintain(String maintain) {
		this.maintain = maintain;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "ServerBean [id=" + id + ", ip=" + ip + ", name=" + name + ", state=" + state + ", maintain=" + maintain
				+ "]";
	}


	

	
	
}
