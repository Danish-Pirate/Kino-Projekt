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
    @Autowired
    private iMovieService iMovieService;


    @Override
    @GetMapping("/title")
    public ResponseEntity<Set<Movie>> findByTitle(@RequestBody String name) {
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
