package com.dxctraining.schedulemodule.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

import com.dxctraining.schedulemodule.dto.AirportDto;
import com.dxctraining.schedulemodule.dto.ScheduleDto;
import com.dxctraining.schedulemodule.entities.Schedule;

@Component
public class ScheduleUtil {
	
	public ScheduleDto scheduleDto(Schedule schedule,AirportDto airportDto) {
		ScheduleDto dto = new ScheduleDto();
		dto.setScheduleId(schedule.getScheduleId());
		LocalDateTime arrivalTime = schedule.getArrivalTime();
		long arrival = toMillis(arrivalTime);
		dto.setArrivalTime(arrival);
		LocalDateTime departureTime = schedule.getDepartureTime();
		long departure = toMillis(departureTime);
		dto.setDepartureTime(departure);
		dto.setSourceAirport(schedule.getSourceAirport());
		dto.setDestinationAirport(schedule.getDestinationAirport());
		dto.setAirportCode(schedule.getAirportCode());
		dto.setAirportName(airportDto.getAirportName());
		dto.setAirportLocation(airportDto.getAirportLocation());
		return dto;
	}
	
	long toMillis(LocalDateTime arrivalTime){
        ZonedDateTime zonedDateTime=ZonedDateTime.of(arrivalTime, ZoneId.systemDefault());
       long millis= zonedDateTime.toInstant().toEpochMilli();
       return millis;
    }

}
