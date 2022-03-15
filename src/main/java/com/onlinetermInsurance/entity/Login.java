package com.onlinetermInsurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.springframework.lang.Nullable;

@Entity(name="LOGIN")
@Table(name="LOGIN")
public class Login {
	
	
	@SequenceGenerator(name = "seq_id", sequenceName = "seq_id", allocationSize = 1)
	@Id
	@Column(name="l_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_id")
	private int lId;
	
	
	@NotNull(message = "username should not be null")
	@Column(name="username",nullable=false,unique=true)
	private String userName;
	
	@Pattern(regexp = "[A-Za-z0-9]+@[a-z]+\\.[a-z]{2,3}",message = "invalid Email id")
	@Column(name="Email_address")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="password",nullable = false)
	private String password;
	
	@Nullable
	@Column(name="user_type",nullable = false)
	private String userType;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private User user;
	
	public Login() {
		super();
	}
	
	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Login(@NotNull(message = "username should not be null") String userName,
			@Pattern(regexp = "[A-Za-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "invalid Email id") String email,
			String password, String userType, @NotNull User user) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Login [lId=" + lId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", userType=" + userType + ", user=" + user + "]";
	}
}
