package com.BookMyShow.book_my_show.Models;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public List<TicketEntity> getListOfTickets() {
		return listOfTickets;
	}

	public void setListOfTickets(List<TicketEntity> listOfTickets) {
		this.listOfTickets = listOfTickets;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mobile;

    @CreationTimestamp
    @Temporal(value =TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedOn;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<TicketEntity> listOfTickets;

}
