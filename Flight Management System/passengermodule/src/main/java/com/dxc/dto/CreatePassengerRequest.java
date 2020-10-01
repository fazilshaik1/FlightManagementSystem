package com.dxc.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePassengerRequest {
	@NotEmpty
	@Size(min = 2, message = "Name should have atleast two characters ")
	private String passengerName;
	@NotNull(message="passenger age should not be empty")
	private int passengerAge;
	@NotNull
	private long passengerUIN;
	@NotNull(message="gender should not be empty")
	private char gender;

	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public long getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(long passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	

}