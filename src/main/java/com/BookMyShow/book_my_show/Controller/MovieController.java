package com.BookMyShow.book_my_show.Controller;

import com.BookMyShow.book_my_show.RequestDto.MovieRequestDto;
import com.BookMyShow.book_my_show.ResponseDto.MovieResponseDto;
import com.BookMyShow.book_my_show.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing movie-related endpoints.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    /**
     * Add a new movie.
     *
     * @param movieRequestDto Request body containing movie details.
     * @return A success message indicating the movie was added successfully.
     */
    @PostMapping("/add")
    public String addMovie(@RequestBody MovieRequestDto movieRequestDto) {
        return movieService.addMovie(movieRequestDto);
    }

    /**
     * Get a movie by its name.
     *
     * @param name The name of the movie to retrieve.
     * @return ResponseEntity containing the movie information if found, or a
     *         NOT_FOUND status if the movie doesn't exist.
     */
    @GetMapping("/get_movie_by_name")
    public ResponseEntity<MovieResponseDto> getMovieByName(@RequestParam("name") String name) {
        MovieResponseDto movie;
        try {
            movie = movieService.getMovieByName(name);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    /**
     * Delete a movie by its ID.
     *
     * @param movieId The ID of the movie to delete.
     * @return A success message indicating the movie was deleted successfully, or
     *         an error message if the movie doesn't exist.
     */
    @DeleteMapping("delete")
    public String deleteMovie(@RequestParam("id") int movieId) {
        String res;
        try {
            res = movieService.deleteMovie(movieId);
        } catch (Exception e) {
            return e.getMessage();
        }
        return res;
    }
}
