package com.capg.MovieMgmt.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.capg.MovieMgmt.entities.Seat;
public class ShowDetailsDto {

	private int showId;
	private String showName;
	private LocalDateTime showStartTime ;
	private LocalDateTime showEndTime  ;
	private String movieName ;
	private List<Seat>seatsId;
	
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndtime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName =  movieName;
	}
	public List<Seat> getSeatsId() {
		return seatsId;
	}
	public void setSeatsId(List<Seat> seatsId) {
		this.seatsId = seatsId;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		// TODO Auto-generated method stub
		
	}

  

}
