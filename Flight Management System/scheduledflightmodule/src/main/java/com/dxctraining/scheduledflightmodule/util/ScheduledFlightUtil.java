package com.dxctraining.scheduledflightmodule.util;

import org.springframework.stereotype.Component;

import com.dxctraining.scheduledflightmodule.dto.FlightDto;
import com.dxctraining.scheduledflightmodule.dto.ScheduleDto;
import com.dxctraining.scheduledflightmodule.dto.ScheduledFlightDto;
import com.dxctraining.scheduledflightmodule.entities.ScheduledFlight;

@Component
public class ScheduledFlightUtil {
	
	public ScheduledFlightDto sfDto(ScheduledFlight scheduledFlight,ScheduleDto scheduleDto,FlightDto flightDto) {
		ScheduledFlightDto dto = new ScheduledFlightDto();
		dto.setSfId(scheduledFlight.getSfId());
		dto.setAvailableSeats(scheduledFlight.getAvailableSeats());
		dto.setScheduleId(scheduleDto.getScheduleId());
		dto.setArrivalTime(scheduleDto.getArrivalTime());
		dto.setDepartureTime(scheduleDto.getDepartureTime());
		dto.setSourceAirport(scheduleDto.getSourceAirport());
		dto.setDestinationAirport(scheduleDto.getDestinationAirport());
		dto.setAirportCode(scheduleDto.getAirportCode());
		dto.setFlightNumber(flightDto.getFlightNumber());
		dto.setFlightModel(flightDto.getFlightModel());
		dto.setCarrierName(flightDto.getCarrierName());
		dto.setSeatCapacity(flightDto.getSeatCapacity());
		return dto;
	}

}
