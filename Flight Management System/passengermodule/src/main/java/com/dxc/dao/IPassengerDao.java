package com.dxc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.entities.Passenger;

public interface IPassengerDao extends JpaRepository<Passenger, Long> {

}
