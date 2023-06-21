package com.BookMyShow.book_my_show.Models;


import com.BookMyShow.book_my_show.Enums.Seat_Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "show_seats")
public class ShowSeatEntity {
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}


	public Date getBooked_at() {
		return booked_at;
	}


	public void setBooked_at(Date booked_at) {
		this.booked_at = booked_at;
	}


	public Seat_Type getSeatType() {
		return seatType;
	}


	public void setSeatType(Seat_Type seatType) {
		this.seatType = seatType;
	}


	public boolean isBooked() {
		return booked;
	}


	public void setBooked(boolean booked) {
		this.booked = booked;
	}


	public ShowEntity getShow() {
		return show;
	}


	public void setShow(ShowEntity show) {
		this.show = show;
	}


	public TicketEntity getTicket() {
		return ticket;
	}


	public void setTicket(TicketEntity ticket) {
		this.ticket = ticket;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private Date booked_at;

    @Enumerated(EnumType.STRING)
    private Seat_Type seatType;
    private boolean booked;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;


    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;

}
