package com.dxc.airportmodule.airport.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.airportmodule.airport.dao.IAirportDao;
import com.dxc.airportmodule.airport.entity.Airport;
import com.dxc.airportmodule.airport.exception.InvalidArgumentException;
import com.dxc.airportmodule.airport.exception.AirportNotFoundException;

@Service
@Transactional
public class AirportServiceImpl implements IAirportService {

	@Autowired
	private IAirportDao dao;

	/*
	 * addAirport() method is used to add an airport to the database, by returning the airport
	 */
	@Override
	public Airport addAirport(Airport airport) {
		String newId = generateAirportCode();
		airport.setAirportCode(newId);
		if (dao.existsById(airport.getAirportCode())) {
			throw new InvalidArgumentException("Airport already exists for the mentioned details");
		}
		airport = dao.save(airport);
		return airport;
	}

	/*
	 * findAirportByCode() will fetch the details of one airport by passing the airportCode
	 */
	@Override
	public Airport findAirportByCode(String airportCode) {
		Optional<Airport> optional = dao.findById(airportCode);
		if (!optional.isPresent()) {
			throw new AirportNotFoundException("Airport not found");

		}
		Airport airport = optional.get();
		return airport;
	}

	/*
	 * findAllAirports() method will fetch the list of all airport and its details
	 */
	@Override
	public List<Airport> findAllAirports() {
		List<Airport> allAirports = dao.findAll();
		return allAirports;
	}

	/*
	 * deleteAirport() method will delete an airport and its details from database
	 */
	@Override
	public void deleteAirport(String airportCode) {
		Airport airport = findAirportByCode(airportCode);
		dao.delete(airport);
	}

	/*
	 * generateAirportCode() method is used to generate a string for airport code, 
	 * the method is called during addAirport() method
	 */
	
	private static String generateAirportCode() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int  number = random.nextInt(100);
			sb.append(number);
		}
		return sb.toString();

	}
}
