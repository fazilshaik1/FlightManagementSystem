package com.dxc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Data")
public class User {

	@Id
	@GeneratedValue
	private int userId;

	private String userType;

	private String userName;

	private String email;

	private Long userPhone;

	private String password;

	public User() {
	}

	public User(String userType, String userName, String email, Long userPhone, String password) {
		this.userType = userType;
		this.userName = userName;
		this.email = email;
		this.userPhone = userPhone;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof User)) {
			return false;
		}

		User that = (User) arg;
		boolean isequal = this.userId == that.userId;
		return isequal;
	}

	@Override
	public int hashCode() {
		return userId;
	}

}
