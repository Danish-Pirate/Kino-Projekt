package group3.kino.movieSearch.controller;

import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieSearch.service.iMovieService;
import group3.kino.util.TokenAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MovieSearchController implements iMovieController{
    private iMovieService iMovieService;

    public MovieSearchController(iMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }
    @Override
    @GetMapping("/search-movie/name")
    public ResponseEntity<Set<Movie>> findByName(@RequestParam String name, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(iMovieService.findByName(name), HttpStatus.OK);
    }

    @Override
    @GetMapping("/search-movie/genre")
    public ResponseEntity<Set<Movie>> findByGenre(@RequestParam String movieGenre, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(iMovieService.findByMovieGenre(movieGenre), HttpStatus.OK);
    }

    @Override
    @GetMapping("/search-movie/date")
    public ResponseEntity<Set<Movie>> findByDate(@RequestParam String date, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(iMovieService.findByDate(date), HttpStatus.OK);
    }
}
