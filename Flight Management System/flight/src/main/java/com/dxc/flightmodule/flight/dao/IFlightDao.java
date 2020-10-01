package com.dxc.flightmodule.flight.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.flightmodule.flight.entity.Flight;

public interface IFlightDao extends JpaRepository<Flight, BigInteger>{

}
