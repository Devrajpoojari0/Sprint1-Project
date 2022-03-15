package com.onlinetermInsurance.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity(name="USER_POLICY")
@Table(name="USER_POLICY")
public class UserPolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_policy_id")
	int userpolicyid;
	@Column(name="user_id")
	int userid;
	@Column(name="policy_id")
	int policyid;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING )
	@Column(name="registered_date")
	Date registeredDate;
	@Column(name="amount")
	double amount;
	@Column(name="total_time")
	int totalTime;
	@Column(name="months_over")
	int monthOver;
	@Column(name="amount_paid")
	double amountPaid;
	
	public UserPolicy() {
		super();
	}
	public UserPolicy(int userid, int policyid, Date registeredDate, double amount, int totalTime,
			int monthOver, double amountPaid) {
		super();
		//this.userpolicyid = userpolicyid;
		this.userid = userid;
		this.policyid = policyid;
		this.registeredDate = registeredDate;
		this.amount = amount;
		this.totalTime = totalTime;
		this.monthOver = monthOver;
		this.amountPaid = amountPaid;
	}
	public int getUserpolicyid() {
		return userpolicyid;
	}
	public void setUserpolicyid(int userpolicyid) {
		this.userpolicyid = userpolicyid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPolicyid() {
		return policyid;
	}
	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public int getMonthOver() {
		return monthOver;
	}
	public void setMonthOver(int monthOver) {
		this.monthOver = monthOver;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	@Override
	public String toString() {
		return "userPolicy [userpolicyid=" + userpolicyid + ", userid=" + userid + ", policyid=" + policyid
				+ ", registeredDate=" + registeredDate + ", amount=" + amount + ", totalTime=" + totalTime
				+ ", monthOver=" + monthOver + ", amountPaid=" + amountPaid + "]";
	}
	

}
