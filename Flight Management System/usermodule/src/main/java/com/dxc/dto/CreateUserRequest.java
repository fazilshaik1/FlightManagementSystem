package com.dxc.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequest {
	@NotEmpty(message="usertype can not be empty")
	private String userType;
	@NotEmpty
	@Size(min = 2, message = "Name should have atleast two characters ")
	private String userName;
	@NotEmpty(message="please provide email")
	private String email;
	@NotNull(message="phone number can not be null.please provide correct phone number")
	private Long userPhone;
	@NotEmpty(message="password can not be empty")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

}
