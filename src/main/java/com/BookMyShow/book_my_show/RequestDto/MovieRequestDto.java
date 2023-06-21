package com.BookMyShow.book_my_show.RequestDto;

import lombok.Data;

import java.util.Date;
@Data
public class MovieRequestDto {
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	private String name;
    private int duration;
    private Date releaseDate;

}
