package com.onlinetermInsurance.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "healthmodule")
public class HealthModule {

	@Id
	@ApiModelProperty(notes = "Medical_Id of the User",name="medicalId",required=true,value="test name")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer medicalId;
	@ApiModelProperty(notes = "AadharNo of the User",name="aadharNo",required=true,value="test name")
	private String aadharNo;
	@ApiModelProperty(notes = "Name of the User",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Address of the User",name="address",required=true,value="test name")
	private String address;
	@ApiModelProperty(notes = "PhoneNo of the User",name="phoneNo",required=true,value="test name")
	private String phoneNo;
	@ApiModelProperty(notes = "Age of the User",name="age",required=true,value="test name")
	private int age;
	@ApiModelProperty(notes = "Do you have any major accident",name="accident",required=true,value="test name")
	private String accident;
	@ApiModelProperty(notes = "Do you use alcohol and smoke",name="accident",required=true,value="test name")
	private String alcohol;
	public HealthModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public HealthModule(Integer medicalId, String aadharNo, String name, String address, String phoneNo, int age,
			String accident, String alcohol) {
		super();
		this.medicalId = medicalId;
		this.aadharNo = aadharNo;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.age = age;
		this.accident = accident;
		this.alcohol = alcohol;
	}
	
		
	@Column(name = "Medical_Id",nullable=false)
	public Integer getMedicalId() {
		return medicalId;
	}
	public void setMedicalId(Integer medicalId) {
		this.medicalId = medicalId;
	}
	@Column(name = "Aadhar_No",nullable=false)
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	@Column(name = "Name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "Address",nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "Phone_No",nullable=false)
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Column(name = "Age",nullable=false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Column(name="Accident",nullable=false)
	public String getAccident() {
		return accident;
	}
	public void setAccident(String accident) {
		this.accident = accident;
	}
	@Column(name="Alcohol",nullable=false)
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	@Override
	public String toString() {
		return "HealthModule [medicalId=" + medicalId + ", aadharNo=" + aadharNo + ", name=" + name + ", address="
				+ address + ", phoneNo=" + phoneNo + ", age=" + age + "]";
	}
}