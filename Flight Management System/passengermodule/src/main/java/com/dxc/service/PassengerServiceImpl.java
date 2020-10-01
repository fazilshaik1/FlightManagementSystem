package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.IPassengerDao;
import com.dxc.entities.Passenger;
import com.dxc.exceptions.InvalidArgumentException;
import com.dxc.exceptions.PassengerNotFoundException;


import java.util.Optional;

@Service
public class PassengerServiceImpl implements IPassengerService {

	@Autowired
	IPassengerDao passengerDao;

	@Override
	public Passenger addPassenger(Passenger passenger) {
		validate(passenger);
		passenger= passengerDao.save(passenger);
		return passenger;

	}

	public void validate(Passenger passenger) {
		if (passenger == null) {
			throw new InvalidArgumentException("passenger can not be null");
		}
	}

	@Override
	public Passenger getPassenger(long pnrNumber) {
		Optional<Passenger> optional = passengerDao.findById(pnrNumber);
		if (!optional.isPresent()) {
			throw new PassengerNotFoundException("passenger not found for id=" + pnrNumber);
		}
		Passenger passenger = optional.get();
		return passenger;
	}

	@Override
	public List<Passenger> viewAllPassengers() {
		List<Passenger> passengers = passengerDao.findAll();
		return passengers;
	}

	@Override
	public void deletePassenger(long pnrNumber) {
		passengerDao.deleteById(pnrNumber);

	}
	
	

}
