package com.BookMyShow.book_my_show.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "shows")

public class ShowEntity {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public TheatreEntity getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreEntity theatre) {
		this.theatre = theatre;
	}

	public List<ShowSeatEntity> getListOfSeats() {
		return listOfSeats;
	}

	public void setListOfSeats(List<ShowSeatEntity> listOfSeats) {
		this.listOfSeats = listOfSeats;
	}

	public List<TicketEntity> getListOfTickets() {
		return listOfTickets;
	}

	public void setListOfTickets(List<TicketEntity> listOfTickets) {
		this.listOfTickets = listOfTickets;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private Double multiplier;

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<ShowSeatEntity> listOfSeats;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfTickets;
}
