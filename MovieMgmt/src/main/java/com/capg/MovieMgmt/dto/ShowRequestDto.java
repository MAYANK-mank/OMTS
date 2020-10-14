package com.capg.MovieMgmt.dto;

import java.time.LocalDateTime;

public class ShowRequestDto {
	
	private LocalDateTime showStartTime ;
	private LocalDateTime showEndTime ;
    private String showName ;
    private String movieName ;
//	private int theaterId;
//    private int screenId;
    
	
    public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
//	public int getTheaterId() {
//		return theaterId;
//	}
//	public void setTheaterId(int theaterId) {
//		this.theaterId = theaterId;
//	}
//	public int getScreenId() {
//		return screenId;
//	}
//	public void setScreenId(int screenId) {
//		this.screenId = screenId;
//	}
	
	
	

}
 