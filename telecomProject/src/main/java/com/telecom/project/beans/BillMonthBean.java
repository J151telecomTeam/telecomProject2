package com.telecom.project.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 月账单bean
 * @author 
 *
 */
public class BillMonthBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3843933682341894721L;
	
	private long id; //主键
	
	private String idCard; //用户身份证号
	
	private String zwAccount; // 账务账号
	
	private double price; //月费用
	
	private Date date; //日期，格式  年-月
	
	private String payWay; //支付方式
	
	private int state; //支付状态
	
	public BillMonthBean() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getZwAccount() {
		return zwAccount;
	}

	public void setZwAccount(String zwAccount) {
		this.zwAccount = zwAccount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "BillMonthBean [id=" + id + ", idCard=" + idCard + ", zwAccount=" + zwAccount + ", price=" + price
				+ ", date=" + date + ", payWay=" + payWay + ", state=" + state + "]";
	}
	
	

}
