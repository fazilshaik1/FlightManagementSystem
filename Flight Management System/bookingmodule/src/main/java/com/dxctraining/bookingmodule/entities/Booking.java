package com.dxctraining.bookingmodule.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue
	private BigInteger bookingId;

	private Integer userId;
	
	private LocalDateTime bookingDate;

	private double ticketCost;
	
	private long pnrNumber;

	private BigInteger sfId;

	public Booking() {

	}

	public Booking(Integer userId, LocalDateTime bookingDate, double ticketCost, long pnrNumber,BigInteger sfId ) {
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.pnrNumber = pnrNumber;
		this.sfId = sfId;
	}

	public BigInteger getBookingId() {
		return bookingId;
	}

	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	
	public long getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public BigInteger getSfId() {
		return sfId;
	}

	public void setSfId(BigInteger sfId) {
		this.sfId = sfId;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass()!= o.getClass()) {
			return false;
		}
		Booking booking =(Booking)o;
		return Objects.equals(bookingId, booking.getBookingId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bookingId);
	}
}