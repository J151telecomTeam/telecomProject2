package com.telecom.project.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 月账单bean
 * @author 
 *
 */
@Entity
@Table(name="t_bill_month",catalog="telecom")
public class BillMonthBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3843933682341894721L;
	
	@Id
	@Column(name="b_id")
	@GenericGenerator(name="bill.id",strategy="identity")
	@GeneratedValue(generator="bill.id")
	private long id; //主键
	
	@Column(name="b_idcard",length=20)
	private String idCard; //用户身份证号
	
	@Column(name="b_zw_account",length=20)
	private String zwAccount; // 账务账号
	
	@Column(name="b_price")
	private double price; //月费用
	
	@Column(name="b_date")
	private String date; //日期，格式  年-月
	
	@Column(name="b_payway")
	private String payWay; //支付方式
	
	@Column(name="b_state")
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



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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
