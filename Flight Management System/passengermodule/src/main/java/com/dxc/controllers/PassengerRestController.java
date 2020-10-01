package com.dxc.controllers;

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
import com.dxc.exceptions.PassengerNotFoundException;
import com.dxc.service.IPassengerService;
import com.dxc.util.PassengerUtil;

@RestController
@RequestMapping("/passengers")
public class PassengerRestController {
	@Autowired
	IPassengerService passengerService;
	@Autowired
	private PassengerUtil passengerUtil;

	@PostMapping(value = "/addPassenger")
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
		Passenger passenger = passengerService.getPassenger(pnrNumber);
		if (passenger == null) {
			throw new PassengerNotFoundException("enter valid number");
		}
		PassengerDto response = passengerUtil.passengerDto(passenger);
		return response;

	}

	@GetMapping("/passengerList")
	public List<Passenger> viewAllPassengers() {
		return passengerService.viewAllPassengers();
	}

	@DeleteMapping("/delete/{pnrNumber}")
	public void deletePassengerBypnrNumber(@PathVariable("pnrNumber") long pnrNumber) {
		try {
			passengerService.deletePassenger(pnrNumber);
			System.out.println("deleted successfully");
		} catch (Exception e) {
			System.out.println(" pnrNumber not found");
		}
	}

}
