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

	@Override
	public Airport addAirport(Airport airport) {
		// String airportCode = generateAirportCode(alphaNum);
		airport.setAirportCode(generateAirportCode(alphaNum));
		if (dao.existsById(airport.getAirportCode())) {
			throw new InvalidArgumentException("Airport already exists for the mentioned details");
		}

		airport = dao.save(airport);
		return airport;
	}

	@Override
	public boolean deleteAirport(String airportCode) {
		if (dao.existsById(airportCode)) {
			
			dao.deleteById(airportCode);
		}else {
			throw new AirportNotFoundException("Airport not found. Please enter the correct Airport code");
		}
		
		return true;
	}

	@Override
	public List<Airport> viewAllAirports() {
		List<Airport> allAirports = dao.findAll();
		return allAirports;
	}

	@Override
	public Airport viewAirportByCode(String airportCode) {
		Optional<Airport> optional = dao.findById(airportCode);
		if (!optional.isPresent()) {
			throw new AirportNotFoundException("Airport not found");

		}
		Airport airport = optional.get();
		return airport;
	}

	String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // 36 letter.

	private static String generateAirportCode(String alphaNum) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			int randIndex = random.nextInt(alphaNum.length());
			sb.append(alphaNum.charAt(randIndex));
		}
		return sb.toString();

	}
}
