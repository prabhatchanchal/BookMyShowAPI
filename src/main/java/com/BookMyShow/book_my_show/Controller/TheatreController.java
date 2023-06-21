package com.BookMyShow.book_my_show.Controller;

import com.BookMyShow.book_my_show.RequestDto.TheatreRequestDto;
import com.BookMyShow.book_my_show.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing theatre-related endpoints.
 */
@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    /**
     * Add a new theatre.
     *
     * @param theatreRequestDto Request body containing theatre details.
     * @return A success message indicating the theatre was added successfully.
     */
    @PostMapping("add")
    public String addTheatre(@RequestBody TheatreRequestDto theatreRequestDto) {
        return theatreService.addTheatre(theatreRequestDto);
    }
}
