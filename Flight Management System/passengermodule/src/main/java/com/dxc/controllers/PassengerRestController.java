package com.dxc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.dto.CreatePassengerRequest;
import com.dxc.dto.PassengerDto;
import com.dxc.entities.Passenger;
import com.dxc.service.IPassengerService;
import com.dxc.util.PassengerUtil;

@RestController
@RequestMapping("/passengers")
public class PassengerRestController {
	@Autowired
	private IPassengerService passengerService;
	@Autowired
	private PassengerUtil passengerUtil;

	@PostMapping("/add")
	public PassengerDto create(@Valid @RequestBody CreatePassengerRequest data) {
		String passengerName = data.getPassengerName();
		int passengerAge = data.getPassengerAge();
		long passengerUIN = data.getPassengerUIN();
		char gender=data.getGender();
		Passenger passenger = new Passenger(passengerName, passengerAge, passengerUIN,gender);
		passenger = passengerService.addPassenger(passenger);
		PassengerDto response = passengerUtil.passengerDto(passenger);
		return response;
	}

	@GetMapping("/get/{pnrNumber}")
	public PassengerDto findPassengerByNumber(@PathVariable("pnrNumber") long pnrNumber) {
		Passenger passenger = passengerService.findPassengerById(pnrNumber);
		PassengerDto response = passengerUtil.passengerDto(passenger);
		return response;

	}

	@GetMapping("/all")
	public List<PassengerDto> findAllPassengers() {
		List<Passenger>list=passengerService.findAllPassengers();
		List<PassengerDto>response= new ArrayList<>();
		for(Passenger passenger:list) {
			PassengerDto dto = passengerUtil.passengerDto(passenger);
			response.add(dto);
		}
		return response;
	}

	@DeleteMapping("/delete/{pnrNumber}")
	public void deletePassengerBypnrNumber(@PathVariable("pnrNumber") long pnrNumber) {
			passengerService.deletePassenger(pnrNumber);
			
	}

}
