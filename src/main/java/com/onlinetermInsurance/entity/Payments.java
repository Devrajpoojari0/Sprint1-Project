package com.onlinetermInsurance.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="PAYMENT")
@Table(name="PAYMENT")
public class Payments{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="recript_no")
	private int receiptNo;// receipt no
	
	@Column(name="user_id")
	private int userId;// user id
	
	@Column(name="policy_id")
	int policyNo;//policy id bought.
	
	@Column(name="date_of_payment")
	private Date dateOfPayment;//time now
	@Column(name="amount")
	private double amount;//amount
	public Payments() {// zero args constructor
		super();
	}
	public Payments( int userId, int policyNo, Date dateOfPayment, double amount) {
		super();//paramaterised constructor
		
		this.userId = userId; 
		this.policyNo = policyNo;
		this.dateOfPayment = dateOfPayment;
		this.amount = amount;
	}
	
	public int getReceiptNo() {
		return receiptNo;
	}
	
	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getPolicyNo() {
		return policyNo;
	}
	
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Payment [receiptNo=" + receiptNo + ", userId=" + userId + ", policyNo=" + policyNo + ", dateOfPayment="
				+ dateOfPayment + ", amount=" + amount + "]";
	}
	
}
