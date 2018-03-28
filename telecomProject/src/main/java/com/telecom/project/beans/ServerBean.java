package com.telecom.project.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(catalog="telecom",name="t_service")
public class ServerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4207885277456404389L;

	@Id
	@Column(name="s_id")
	@GenericGenerator(name= "hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private long id; //主键
	 
	@Column(name="s_ip",length=30)
	private String ip; //服务器ip
	
	@Column(name="s_name",length=20)
	private String name; //服务器名
	
	@Column(name="s_state",length=20)
	private String state; //状态
	
	@Column(name="s_maintain",length=20)
	private String maintain; //服务器状态
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="server")
	@Cascade(value= {CascadeType.ALL})
	private List<BusinessAccountBean> business;

	public ServerBean() {
		// TODO Auto-generated constructor stub
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	

	public List<BusinessAccountBean> getBusiness() {
		return business;
	}

	public void setBusiness(List<BusinessAccountBean> business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "ServerBean [id=" + id + ", ip=" + ip + ", name=" + name + ", state=" + state + ", maintain=" + maintain
				+ "]";
	}
	
	
	
}
