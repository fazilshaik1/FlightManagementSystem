package com.dxc.airportmodule.airport.service;

import java.util.List;

import com.dxc.airportmodule.airport.entity.Airport;

public interface IAirportService {

	 Airport addAirport(Airport airport);
	
	 boolean deleteAirport(String airportCode);
	
	 List<Airport> viewAllAirports();
	
	 Airport viewAirportByCode(String airportCode);
}
