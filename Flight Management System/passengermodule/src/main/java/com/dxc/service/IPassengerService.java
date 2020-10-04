package com.dxc.service;

import java.util.List;

import com.dxc.entities.Passenger;

public interface IPassengerService {
	public Passenger findPassengerById(long pnrNumber);

	public List<Passenger> findAllPassengers();

	public Passenger addPassenger(Passenger passenger);

	public void deletePassenger(long pnrNumber);

}
