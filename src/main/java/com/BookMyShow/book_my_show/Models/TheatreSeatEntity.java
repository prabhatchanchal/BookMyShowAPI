package com.BookMyShow.book_my_show.Models;


import com.BookMyShow.book_my_show.Enums.Seat_Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="theatre_seats")
public class TheatreSeatEntity {
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

	public Seat_Type getSeatType() {
		return seatType;
	}

	public void setSeatType(Seat_Type seatType) {
		this.seatType = seatType;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public TheatreEntity getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreEntity theatre) {
		this.theatre = theatre;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    @Enumerated(EnumType.STRING)
    private Seat_Type seatType;
    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    public TheatreSeatEntity(String seatNo,Seat_Type seatType, int rate) {
        this.seatNo=seatNo;
        this.seatType=seatType;
        this.rate=rate;
    }
}
