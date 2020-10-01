package com.dxc.airportmodule.airport.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.airportmodule.airport.entity.Airport;

public interface IAirportDao extends JpaRepository<Airport, String>{

}
