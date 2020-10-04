package com.dxc.airportmodule.airport.service;

import java.util.List;

import com.dxc.airportmodule.airport.entity.Airport;

public interface IAirportService {

	 Airport addAirport(Airport airport);
	
	 void deleteAirport(String airportCode);
	
	 List<Airport> findAllAirports();
	
	 Airport findAirportByCode(String airportCode);
}
