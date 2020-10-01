package com.dxc.util;

import org.springframework.stereotype.Component;

import com.dxc.dto.PassengerDto;
import com.dxc.entities.Passenger;

@Component
public class PassengerUtil {
	public PassengerDto passengerDto(Passenger passenger) {
		PassengerDto dto = new PassengerDto(passenger.getPnrNumber(), passenger.getPassengerName(),
				passenger.getPassengerAge(), passenger.getPassengerUIN(),passenger.getGender());
		return dto;
	}

}
