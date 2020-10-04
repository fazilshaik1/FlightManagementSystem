package com.dxctraining.bookingmodule.util;

import com.dxctraining.bookingmodule.dto.BookingDto;
import com.dxctraining.bookingmodule.dto.PassengerDto;
import com.dxctraining.bookingmodule.dto.ScheduledFlightDto;
import com.dxctraining.bookingmodule.dto.UserDto;
import com.dxctraining.bookingmodule.entities.Booking;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

@Component
public class BookingUtil {
	
	public BookingDto bookingDto(Booking booking,UserDto userDto,PassengerDto passengerDto,ScheduledFlightDto sfDto) {
		BookingDto dto = new BookingDto();
		dto.setBookingId(booking.getBookingId());
		LocalDateTime bookingDate = booking.getBookingDate();
		long millis = toMillis(bookingDate);
		dto.setBookingDate(millis);
		dto.setTicketCost(booking.getTicketCost());
		dto.setUserId(userDto.getUserId());
		dto.setUserName(userDto.getUserName());
		dto.setEmail(userDto.getEmail());
		dto.setUserPhone(userDto.getUserPhone());
		dto.setPnrNumber(passengerDto.getPnrNumber());
		dto.setPassengerName(passengerDto.getPassengerName());
		dto.setPassengerAge(passengerDto.getPassengerAge());
		dto.setPassengerUIN(passengerDto.getPassengerUIN());
		dto.setGender(passengerDto.getGender());
		dto.setSfId(sfDto.getSfId());
		dto.setAvailableSeats(sfDto.getAvailableSeats());
		dto.setFlightNumber(sfDto.getFlightNumber());
		return dto;
	}
	
	 long toMillis(LocalDateTime dateTime){
	        ZonedDateTime zonedDateTime=ZonedDateTime.of(dateTime, ZoneId.systemDefault());
	       long millis= zonedDateTime.toInstant().toEpochMilli();
	       return millis;
	    }
}