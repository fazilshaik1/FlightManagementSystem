package com.dxc.flightmodule.flight.service;

import java.math.BigInteger;
import java.util.List;

import com.dxc.flightmodule.flight.entity.Flight;

public interface IFlightService {

	Flight addFlight(Flight flight);
	
	Flight modifyFlight(Flight flight);
	
	Flight findFlightByFlightNumber(BigInteger flightNumber);
	
	List<Flight> findAllFlights();
	
	void deleteFlight(BigInteger flightNumber);
	
	void validateFlight(Flight flight);
}
