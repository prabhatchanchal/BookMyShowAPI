package com.BookMyShow.book_my_show.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="theatre")
@Data
@NoArgsConstructor
public class TheatreEntity {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<TheatreSeatEntity> getTheatreSeatEntityList() {
		return theatreSeatEntityList;
	}

	public void setTheatreSeatEntityList(List<TheatreSeatEntity> theatreSeatEntityList) {
		this.theatreSeatEntityList = theatreSeatEntityList;
	}

	public List<ShowEntity> getListOfShows() {
		return listOfShows;
	}

	public void setListOfShows(List<ShowEntity> listOfShows) {
		this.listOfShows = listOfShows;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<TheatreSeatEntity> theatreSeatEntityList;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<ShowEntity> listOfShows;

}
