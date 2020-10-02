package com.dxctraining.scheduledflightmodule.dto;

import java.math.BigInteger;

public class ScheduledFlightDto {
	
	private BigInteger sfId;
	
	private Integer availableSeats;
	
	private Integer scheduleId;
	
	private BigInteger flightNumber;
	
	private long arrivalTime;
	
	private long departureTime;
	
	private String sourceAirport;
	
	private String destinationAirport;
	
	private String airportCode;
	
	private String flightModel;
	
	private String carrierName;
	
	private Integer seatCapacity;
	
	public ScheduledFlightDto() {
		
	}
	
	public ScheduledFlightDto(BigInteger sfId, Integer availableSeats) {
		this.sfId = sfId;
		this.availableSeats= availableSeats;
	}

	public BigInteger getSfId() {
		return sfId;
	}

	public void setSfId(BigInteger sfId) {
		this.sfId = sfId;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public BigInteger getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public long getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(long departureTime) {
		this.departureTime = departureTime;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Integer getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

}
