package com.dxctraining.schedulemodule.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.schedulemodule.dto.AirportDto;
import com.dxctraining.schedulemodule.dto.CreateScheduleDto;
import com.dxctraining.schedulemodule.dto.ScheduleDto;
import com.dxctraining.schedulemodule.entities.Schedule;
import com.dxctraining.schedulemodule.service.IScheduleService;
import com.dxctraining.schedulemodule.util.DateUtil;
import com.dxctraining.schedulemodule.util.ScheduleUtil;

@Validated
@RestController
@RequestMapping("/schedules")
public class ScheduleRestController {
	
	@Autowired
	private IScheduleService service;
	
	@Autowired
	private ScheduleUtil util;
	
	@Autowired
	private DateUtil dateUtil;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ScheduleDto addSchedule(@RequestBody @Valid CreateScheduleDto requestData) {
		long arrival= requestData.getArrivalTime();
		long departure = requestData.getDepartureTime();
		LocalDateTime arrivalTime =dateUtil.toDateTime(arrival);
		LocalDateTime departureTime = dateUtil.toDateTime(departure);
		Schedule schedule = new Schedule();
		schedule.setArrivalTime(arrivalTime);
		schedule.setDepartureTime(departureTime);
		schedule.setSourceAirport(requestData.getSourceAirport());
		schedule.setDestinationAirport(requestData.getDestinationAirport());
		schedule.setAirportCode(requestData.getAirportCode());
		schedule = service.save(schedule);
		AirportDto airportDto = findAirportByAirportId(requestData.getAirportCode());
		ScheduleDto response = util.scheduleDto(schedule, airportDto);
		return response;
	}
	
	@GetMapping("/get/{scheduleId}")
	public ScheduleDto findByScheduleId(@PathVariable("scheduleId") Integer scheduleId) {
		Schedule schedule = service.findByScheduleId(scheduleId);
		AirportDto airportDto = findAirportByAirportId(schedule.getAirportCode());
		ScheduleDto response = util.scheduleDto(schedule, airportDto);
		return response;
	}
	
	@GetMapping("/all")
	public List<ScheduleDto> fetchAll(){
		List<Schedule> list = service.allSchedules();
		List<ScheduleDto> response = new ArrayList<>();
		for(Schedule schedule:list) {
			String airportCode = schedule.getAirportCode();
			AirportDto airportDto = findAirportByAirportId(airportCode);
			ScheduleDto dto = util.scheduleDto(schedule, airportDto);
			response.add(dto);
		}
		return response;
	}
	
	@DeleteMapping("/delete/{scheduleId}")
	public void deleteSchedule(@PathVariable("scheduleId")Integer scheduleId) {
		service.deleteSchedule(scheduleId);
	}

	private AirportDto findAirportByAirportId(String airportCode) {
		String url = "http://airport/airports/get/"+airportCode;
		AirportDto dto = restTemplate.getForObject(url, AirportDto.class);
		return dto;
	}

}
