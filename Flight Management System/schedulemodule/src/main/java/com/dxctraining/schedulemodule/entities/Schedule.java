package com.dxctraining.schedulemodule.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id
	@GeneratedValue
	private Integer scheduleId;
	
	private LocalDateTime arrivalTime;
	
	private LocalDateTime departureTime;
	
	private String sourceAirport;
	
	private String destinationAirport;
	
	private String airportCode;
	
	public Schedule() {
		
	}
	
	public Schedule(LocalDateTime arrivalTime, LocalDateTime departureTime,String sourceAirport,String destinationAirport, String airportCode) {
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.airportCode = airportCode;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
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
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass()!= o.getClass()) {
			return false;
		}
		Schedule schedule =(Schedule)o;
		return Objects.equals(scheduleId, schedule.getScheduleId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(scheduleId);
	}

}
