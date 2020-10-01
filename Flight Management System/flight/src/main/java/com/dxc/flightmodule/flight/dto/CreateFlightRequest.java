package com.dxc.flightmodule.flight.dto;

import javax.validation.constraints.NotEmpty;

public class CreateFlightRequest {

	@NotEmpty(message = "Flight Name cannot be empty. Please provide correct name")
	private String flightModel;

	@NotEmpty(message = "Flight carrier name cannot be empty. Please provide correct name")
	private String carrierName;

	@NotEmpty(message = "Seat cannot be empty. Please provide required number of seats")
	private Integer seatCapacity;

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
