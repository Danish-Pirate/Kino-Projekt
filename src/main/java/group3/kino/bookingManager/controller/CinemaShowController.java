package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.CinemaShow;
import group3.kino.bookingManager.service.IShowingService;
import group3.kino.bookingManager.service.ShowingService;
import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieAdministration.service.IMovieAdminService;
import group3.kino.movieAdministration.service.MovieAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CinemaShowController {

    private IShowingService showService;
    private IMovieAdminService movieService;

    public CinemaShowController(ShowingService showService, MovieAdminService movieService) {
        this.showService = showService;
        this.movieService = movieService;
    }

    @PostMapping("addShowToMovie/{movieId}")
    public ResponseEntity<String> addShowToMovie(@RequestBody CinemaShow cinemaShow, @PathVariable("movieId") Long movieId){
        Movie movie = movieService.findById(movieId).get();
        movie.addCinemaShow(cinemaShow);
        movieService.save(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
