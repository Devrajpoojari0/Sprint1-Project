package com.onlinetermInsurance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="POLICY")
public class Policy {
	@Id
	@Column(name="policy_id",nullable=false)
	int id;
	@Column(name="description",nullable=false)
	private String description;
	@Column(name="age_for_term",nullable=false)
	private int yearsOfPayment;
	@Column(name="amount",nullable=false)
	private double amount;
	@Column(name="maturity_period",nullable=false)
	private int maturityperiod;
	@Column(name="maturity_amount",nullable=false)
	private double maturityamount;
	
	public Policy() {
		super();
	}
	public Policy(int id, String description, int yearsOfPayment, double amount, int maturityperiod,
			double maturityamount) {
		super();
		this.id = id;
		this.description = description;
		this.yearsOfPayment = yearsOfPayment;
		this.amount = amount;
		this.maturityperiod = maturityperiod;
		this.maturityamount = maturityamount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYearsOfPayment() {
		return yearsOfPayment;
	}
	public void setYearsOfPayment(int yearsOfPayment) {
		this.yearsOfPayment = yearsOfPayment;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	public int getMaturityperiod() {
		return maturityperiod;
	}
	public void setMaturityperiod(int maturityperiod) {
		this.maturityperiod = maturityperiod;
	}
	public double getMaturityamount() {
		return maturityamount;
	}
	public void setMaturityamount(double d) {
		this.maturityamount = d;
	}
	@Override
	public String toString() {
		return "Policy [id=" + id + ", description=" + description + ", yearsOfPayment=" + yearsOfPayment + ", amount="
				+ amount + ", maturityperiod=" + maturityperiod + ", maturityamount=" + maturityamount + "]";
	}
	

}
	