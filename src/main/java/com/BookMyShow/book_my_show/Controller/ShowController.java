package com.BookMyShow.book_my_show.Controller;

import com.BookMyShow.book_my_show.RequestDto.ShowRequestDto;
import com.BookMyShow.book_my_show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing show-related endpoints.
 */
@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    /**
     * Add a new show.
     *
     * @param showRequestDto Request body containing show details.
     * @return A success message indicating the show was added successfully.
     */
    @PostMapping("add")
    public String addShow(@RequestBody ShowRequestDto showRequestDto) {
        return showService.addShow(showRequestDto);
    }
}
