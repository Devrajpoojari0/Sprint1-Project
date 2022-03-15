package com.onlinetermInsurance.entity;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.Nullable;

@Entity(name="USER_DETAILS")
@Table(name="USER_DETAILS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="user_id")
	private int userId;//user id auto creation
	
	@Column(name="first_name")
	
	@NotNull(message = "first nae Should not be Null")
	private String fname;//name
	
	@Column(name="last_name")
	@NotNull(message = "last Name Should not be Null")
	@NotNull(message = "last name Should not be Null")
	private String lname;
	
	//@Nullable
	//@Length(min = 10,max = 13)
	@Column(name="phone_no")
	private Long phoneNo;          //phone
	
	@Embedded
	Address ad;//address is embedded with address class because no need for address id 
	
	@Column(name="date_of_birth")
	private Date dob;//Date of birth
	
	@Column(name="aadhar_no",length = 12)
	//@NotNull
	private String aadhar;
	// sources in java getter setter AND constructors
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Address getAd() {
		return ad;
	}
	public void setAd(Address ad) {
		this.ad = ad;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	
	
	public User(
			@Pattern(regexp = "^[A-Za-z][A-Za-z0-9]{2,10}$", message = "Use First letter should be Alphabet Min 2 and Max 10") @NotNull(message = "first name Should not be Null") String fname,
			@NotNull(message = "last Name Should not be Null") @NotNull(message = "last name Should not be Null") String lname,
			Long phoneNo, Address ad, Date dob, String aadhar) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phoneNo = phoneNo;
		this.ad = ad;
		this.dob = dob;
		this.aadhar = aadhar;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", phoneNo=" + phoneNo + ", ad="
				+ ad + ", dob=" + dob + ", aadhar=" + aadhar + "]";
	}
	
	
	

}
