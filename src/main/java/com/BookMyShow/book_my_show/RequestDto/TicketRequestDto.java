package com.BookMyShow.book_my_show.RequestDto;
import lombok.Data;

import java.util.List;

@Data
public class TicketRequestDto {
    public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<String> getRequestedSeats() {
		return requestedSeats;
	}
	public void setRequestedSeats(List<String> requestedSeats) {
		this.requestedSeats = requestedSeats;
	}
	private int showId;
    private int userId;
    private List<String> requestedSeats;
}
