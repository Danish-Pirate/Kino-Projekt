package group3.kino.movieSearch.controller;

import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieSearch.service.iMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MovieSearchController implements iMovieController{
    private iMovieService iMovieService;

    public MovieSearchController(iMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }
    @Override
    @GetMapping("/name")
    public ResponseEntity<Set<Movie>> findByName(@RequestBody String name) {
        return new ResponseEntity<>(iMovieService.findByName(name), HttpStatus.OK);
    }

    @Override
    @GetMapping("/genre")
    public ResponseEntity<Set<Movie>> findByGenre(@RequestBody String movieGenre) {
        return new ResponseEntity<>(iMovieService.findByMovieGenre(movieGenre), HttpStatus.OK);
    }

    @Override
    @GetMapping("/date")
    public ResponseEntity<Set<Movie>> findByDate(@RequestBody String date) {
        return new ResponseEntity<>(iMovieService.findByDate(date), HttpStatus.OK);
    }
}
