package com.dxc.dto;


public class UserDto {

	private int userId;
	
	private String userType;
	private String userName;
	private String email;
	private Long userPhone;
	private String password;

	public UserDto() {

	}

	public UserDto(int userId, String userName, String userType, String email, Long userPhone, String password) {
		this.userId = userId;
	
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

}
