package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;
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
 * 角色bean
 * @author 
 *
 */

@Entity
@Table(name="t_role",catalog="telecom")
public class RoleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3127842160765796423L;
	
	@Id
	@Column(name="r_id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private long id; //主键
	
	@Column(name="r_name",length=20)
	private String name; //角色名称
	
	@Column(name="r_founder",length=20)
	private String founder; //创建人
	
	@Column(name="r_create_time")
	private Date createTime; //创建日期
	
	@Column(name="r_describe")
	private String describe; //角色描述
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="role")
	private List<AdminBean>  list;
	
	public RoleBean() {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", name=" + name + ", founder=" + founder + ", createTime=" + createTime
				+ ", describe=" + describe + "]";
	}
	
	

}
