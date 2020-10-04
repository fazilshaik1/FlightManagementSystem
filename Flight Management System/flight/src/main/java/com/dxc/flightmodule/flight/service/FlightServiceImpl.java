package com.dxc.flightmodule.flight.service;

import java.math.BigInteger;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.flightmodule.flight.dao.IFlightDao;
import com.dxc.flightmodule.flight.entity.Flight;
import com.dxc.flightmodule.flight.exception.FlightNotFoundException;
import com.dxc.flightmodule.flight.exception.InvalidArgumentException;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {

	@Autowired
	private IFlightDao dao;

	
	@Override
	public Flight addFlight(Flight flight) {
		validateFlight(flight);
		return dao.save(flight);
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		validateFlight(flight);
		Flight tempFlight = findFlightByFlightNumber(flight.getFlightNumber());
		tempFlight.setFlightModel(flight.getFlightModel());
		tempFlight.setSeatCapacity(flight.getSeatCapacity());
		tempFlight.setCarrierName(flight.getCarrierName());
		dao.save(tempFlight);
		System.out.println("Update successful");
		return tempFlight;
	}

	@Override
	public Flight findFlightByFlightNumber(BigInteger flightNumber) {
		Optional<Flight> optional = dao.findById(flightNumber);
		if (!optional.isPresent()) {
			throw new FlightNotFoundException("Flight not found for entered number. Please provide correct number");
		}
		Flight flight = optional.get();
		return flight;
	}

	@Override
	public List<Flight> findAllFlights() {
		List<Flight> allFlights = dao.findAll();
		return allFlights;
	}

	@Override
	public void deleteFlight(BigInteger flightNumber) {
		Flight flight = findFlightByFlightNumber(flightNumber);
		dao.delete(flight);
	}

	@Override
	public void validateFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Invalid argument is passed");
		}
	}

}
