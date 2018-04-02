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
 * 资费bean
 * 
 * @author
 *
 */
 @Entity
 @Table(name="t_deal",catalog="telecom")
public class DealBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6185355376965343112L;

	@Id
	@Column(name="d_id")
	@GenericGenerator(name="deal.id",strategy="identity")
	@GeneratedValue(generator="deal.id")
	private long id; // 主键

	@Column(name="d_name",length=20)
	private String name; // 资费名称

	@Column(name="d_type")
	private int type; // 资费类型

	@Column(name="d_duration")
	private int duration; // 基本时长

	@Column(name="d_cost")
	private double cost; // 基本费用

	@Column(name="d_money")
	private double money; // 单位费用

	@Column(name="d_msg",length=20)
	private String msg; // 资费说明

	@Column(name="d_delete")
	private int delete; // 删除状态

	@Column(name="d_stop")
	private int stop; // 开通暂停状态

	//mappedBy  属性，作用为：书写在关系具有双向关联关系、并且是属于双向	关系的维护端的类中
	//其值为：此双向关系另一端的属性名
	@OneToMany(fetch=FetchType.LAZY,mappedBy="deal")
	@Cascade(value= {CascadeType.ALL})
	private List<BusinessAccountBean> businessAccount; // 业务账号对象

	public DealBean() {
		// TODO Auto-generated constructor stub
	}

	public int getStop() {
		return stop;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public List<BusinessAccountBean> getBusinessAccount() {
		return businessAccount;
	}

	public void setBusinessAccount(List<BusinessAccountBean> businessAccount) {
		this.businessAccount = businessAccount;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	@Override
	public String toString() {
		return "DealBean [id=" + id + ", name=" + name + ", type=" + type + ", duration=" + duration + ", cost=" + cost
				+ ", money=" + money + ", msg=" + msg + ", delete=" + delete + ", stop=" + stop + ", businessAccount="
				+ businessAccount + "]";
	}

}
