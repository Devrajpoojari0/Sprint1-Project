package com.onlinetermInsurance.entity;




import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.lang.Nullable;

@Embeddable
public class Address {

    @Nullable
	@Column(name="house_no")
	private String houseno;
	@Column(name="city")
	private String city;
	
	@Pattern(regexp="^[A-Za-z-0-99999999")
	@Column(name="street")
	private String street;
	@Column(name="state")
	private String state;
	
	@NotNull
	@Pattern(regexp = "^[1-9][0-9]{6}$",message = "Pin number should be 6 digit")
	@Column(name="pin")
	private String pin;
	
	public Address() {	
		
	}


	public Address(String houseno, String city, String street, String state, String pin) {
		super();
		this.houseno = houseno;
		this.city = city;
		this.street = street;
		this.state = state;
		this.pin = pin;
	}

	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [  houseno=" + houseno + ", city=" + city + ", street=" + street
				+ ", state=" + state + ", pin=" + pin + "]";
	}
	
	
	
}

