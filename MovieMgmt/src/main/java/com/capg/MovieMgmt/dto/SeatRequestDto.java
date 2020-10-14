package com.capg.MovieMgmt.dto;

import com.capg.MovieMgmt.entities.BookingState;

public class SeatRequestDto {

	private BookingState seatStatus;
	private double seatPrice;

	public BookingState getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(BookingState seatStatus) {
		this.seatStatus = seatStatus;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

}