package com.dxctraining.bookingmodule.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.bookingmodule.dto.BookingDto;
import com.dxctraining.bookingmodule.dto.CreateBookingRequest;
import com.dxctraining.bookingmodule.dto.PassengerDto;
import com.dxctraining.bookingmodule.dto.ScheduledFlightDto;
import com.dxctraining.bookingmodule.dto.UserDto;
import com.dxctraining.bookingmodule.entities.Booking;
import com.dxctraining.bookingmodule.service.IBookingService;
import com.dxctraining.bookingmodule.util.BookingUtil;
import com.dxctraining.bookingmodule.util.DateUtil;

import org.springframework.web.client.RestTemplate;

@Validated
@RestController
@RequestMapping("/bookings")
public class BookingRestController {

	@Autowired
	private IBookingService service;

	@Autowired
	private BookingUtil util;
	
	@Autowired
	private DateUtil dateUtil;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public BookingDto createBooking(@RequestBody @Valid CreateBookingRequest req) {
		long bookingDateMillis = req.getBookingDate();
		LocalDateTime bookingDate = dateUtil.toDateTime(bookingDateMillis);
		Booking booking = new Booking(req.getUserId(),bookingDate,req.getTicketCost(),req.getPnrNumber(),req.getSfId());
		booking = service.addBooking(booking);
		UserDto userDto = findUserDetailsByUserId(req.getUserId());
		PassengerDto passDto = findPassengerDetailsByPnrNum(req.getPnrNumber());
		ScheduledFlightDto sfDto = findScheduledFlightBySfId(req.getSfId());
		BookingDto response = util.bookingDto(booking, userDto, passDto, sfDto);
		return response;
	}
	
	@GetMapping("/get/{bookingId}")
	@ResponseStatus(HttpStatus.OK)
	public BookingDto findBookingByBookingId(@PathVariable("bookingId") BigInteger bookingId) {
		Booking booking = service.findByBookingId(bookingId);
		UserDto userDto = findUserDetailsByUserId(booking.getUserId());
		PassengerDto passDto = findPassengerDetailsByPnrNum(booking.getPnrNumber());
		ScheduledFlightDto sfDto = findScheduledFlightBySfId(booking.getSfId());
		BookingDto response = util.bookingDto(booking, userDto, passDto, sfDto);
		return response;
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<BookingDto> allBookings(){
		List<Booking>list= service.viewAllBookings();
		List<BookingDto>response = new ArrayList<>();
		for(Booking booking:list) {
			UserDto userDto = findUserDetailsByUserId(booking.getUserId());
			PassengerDto passDto = findPassengerDetailsByPnrNum(booking.getPnrNumber());
			ScheduledFlightDto sfDto = findScheduledFlightBySfId(booking.getSfId());
			BookingDto dto = util.bookingDto(booking, userDto, passDto, sfDto);
			response.add(dto);
		}
		return response;
	}
	
	@DeleteMapping("/delete/{bookingId}")
	public void deleteBooking(@PathVariable("bookingId")BigInteger bookingId) {
		service.deleteBooking(bookingId);
	}

	private ScheduledFlightDto findScheduledFlightBySfId(BigInteger sfId) {
		String url = "http://scheduledflightmodule/scheduledflights/get/"+sfId;
		ScheduledFlightDto dto = restTemplate.getForObject(url, ScheduledFlightDto.class);
		return dto;
	}

	private PassengerDto findPassengerDetailsByPnrNum(long pnrNumber) {
		String url = "http://passengermodule/passengers/get/"+pnrNumber;
		PassengerDto dto = restTemplate.getForObject(url, PassengerDto.class);
		return dto;
	}

	private UserDto findUserDetailsByUserId(Integer userId) {
		String url = "http://usermodule/users/get/"+userId;
		UserDto dto = restTemplate.getForObject(url, UserDto.class);
		return dto;
	}

}
