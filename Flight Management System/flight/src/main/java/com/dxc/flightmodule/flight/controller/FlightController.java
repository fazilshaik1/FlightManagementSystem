package com.dxc.flightmodule.flight.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.flightmodule.flight.dto.CreateFlightRequest;
import com.dxc.flightmodule.flight.dto.FlightDto;
import com.dxc.flightmodule.flight.entity.Flight;
import com.dxc.flightmodule.flight.service.IFlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private IFlightService service;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public FlightDto create(@RequestBody CreateFlightRequest request) {
		Flight flight = new Flight();
		flight.setFlightModel(request.getFlightModel());
		flight.setCarrierName(request.getCarrierName());
		flight.setSeatCapacity(request.getSeatCapacity());
		flight = service.addFlight(flight);
		FlightDto response = toDto(flight);
		return response;
	}

	@GetMapping("/get/{flightNumber}")
	public FlightDto viewFlight(@PathVariable("flightNumber") BigInteger flightNumber) {
		Flight flight = service.findFlightByFlightNumber(flightNumber);
		FlightDto response = toDto(flight);
		return response;
	}

	@GetMapping("/get/all")
	public List<FlightDto> getAllFlights() {
		List<Flight> list = service.findAllFlights();
		List<FlightDto> response = new ArrayList<>();
		for (Flight flight : list) {
			FlightDto dto = toDto(flight);
			response.add(dto);
		}
		return response;
	}

	@PutMapping("/update")
	public Flight modify(@RequestBody Flight flightToUpdate) {
		Flight flight = service.modifyFlight(flightToUpdate);
		return flight;
	}

	@DeleteMapping("/delete/{flightNumber}")
	public void delete(@PathVariable("flightNumber") BigInteger flightNumber) {
		service.deleteFlight(flightNumber);
	}

	public FlightDto toDto(Flight flight) {
		FlightDto dto = new FlightDto();
		dto.setFlightNumber(flight.getFlightNumber());
		dto.setFlightModel(flight.getFlightModel());
		dto.setCarrierName(flight.getCarrierName());
		dto.setSeatCapacity(flight.getSeatCapacity());
		return dto;
	}

}
