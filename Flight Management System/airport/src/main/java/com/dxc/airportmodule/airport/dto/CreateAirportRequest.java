package com.dxc.airportmodule.airport.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateAirportRequest {

	@NotEmpty(message = "Airport Name cannot be empty. Please provide correct name")
	@Size(min=3,message = "name should be minimum 3 letters long")
	private String airportName;
	
	@NotEmpty(message = "Airport Location cannot be empty. Please provide correct location")
	private String airportLocation;

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	
	
}
