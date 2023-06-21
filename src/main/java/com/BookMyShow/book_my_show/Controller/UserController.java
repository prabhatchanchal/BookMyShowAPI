package com.BookMyShow.book_my_show.Controller;

import com.BookMyShow.book_my_show.RequestDto.UserRequestDto;
import com.BookMyShow.book_my_show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing user-related endpoints.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Add a new user.
     *
     * @param userRequestDto Request body containing user details.
     * @return A success message indicating the user was added successfully.
     */
    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.addUser(userRequestDto);
    }
}
