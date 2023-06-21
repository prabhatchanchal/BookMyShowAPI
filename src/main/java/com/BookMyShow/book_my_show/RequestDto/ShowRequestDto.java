package com.BookMyShow.book_my_show.RequestDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequestDto {
    public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public double getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}
	private int theatreId;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private double multiplier;

}
