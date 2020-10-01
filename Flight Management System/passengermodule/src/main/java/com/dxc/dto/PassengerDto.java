package com.dxc.dto;

public class PassengerDto {

	private long pnrNumber;
	private String passengerName;
	private int passengerAge;
	private long passengerUIN;
	private char gender;
	

	public PassengerDto() {
	}
	public PassengerDto(long pnrNumber,String passengerName,int passengerAge,long passengerUIN,char gender) {
		this.pnrNumber=pnrNumber;
		this.passengerName=passengerName;
		this.passengerAge=passengerAge;
		this.passengerUIN=passengerUIN;
		this.gender=gender;
		
	}
	public long getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
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