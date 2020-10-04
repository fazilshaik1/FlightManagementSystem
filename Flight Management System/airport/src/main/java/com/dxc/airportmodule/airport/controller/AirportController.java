package com.dxc.airportmodule.airport.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.airportmodule.airport.dto.AirportDto;
import com.dxc.airportmodule.airport.dto.CreateAirportRequest;
import com.dxc.airportmodule.airport.entity.Airport;
import com.dxc.airportmodule.airport.service.IAirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {

	@Autowired
	private IAirportService service;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public AirportDto create(@Valid @RequestBody CreateAirportRequest requestData) {
		Airport airport = new Airport();
		airport.setAirportName(requestData.getAirportName());
		airport.setAirportLocation(requestData.getAirportLocation());
		airport = service.addAirport(airport);
		AirportDto response = toDto(airport);
		return response;
	}

	@GetMapping("/get/{airportCode}")
	public AirportDto getAirportByCode(@PathVariable("airportCode") String airportCode) {
		Airport airport = service.findAirportByCode(airportCode);
		AirportDto response = toDto(airport);
		return response;
	}

	@GetMapping("/get/all")
	public List<AirportDto> getAllAirports() {
		List<Airport> list = service.findAllAirports();
		List<AirportDto> response = new ArrayList<>();
		for (Airport airport : list) {
			AirportDto dto = toDto(airport);
			response.add(dto);
		}
		return response;
	}

	@DeleteMapping("/delete/{airportCode}")
	public void delete(@PathVariable("airportCode") String airportCode) {
		service.deleteAirport(airportCode);
	}

	public AirportDto toDto(Airport airport) {
		AirportDto dto = new AirportDto();
		dto.setAirportCode(airport.getAirportCode());
		dto.setAirportName(airport.getAirportName());
		dto.setAirportLocation(airport.getAirportLocation());
		return dto;
	}
}
