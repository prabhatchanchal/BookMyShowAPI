package com.BookMyShow.book_my_show.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tickets")
public class TicketEntity {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlloted_seats() {
		return alloted_seats;
	}

	public void setAlloted_seats(String alloted_seats) {
		this.alloted_seats = alloted_seats;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getBooked_at() {
		return booked_at;
	}

	public void setBooked_at(Date booked_at) {
		this.booked_at = booked_at;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ShowEntity getShow() {
		return show;
	}

	public void setShow(ShowEntity show) {
		this.show = show;
	}

	public List<ShowSeatEntity> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<ShowSeatEntity> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String alloted_seats;
    private int amount;
    private Date booked_at;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> bookedSeats;
}
