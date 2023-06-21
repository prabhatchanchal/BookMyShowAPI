package com.BookMyShow.book_my_show.RequestDto;

import lombok.Data;

@Data
public class UserRequestDto {
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
	private String name;
    private String mobile;
}
