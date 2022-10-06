package group3.kino.movieSearch.controller;

import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieSearch.service.iMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<Set<Movie>> findByName(@RequestParam String name) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(iMovieService.findByName(name));
    }

    @Override
    @GetMapping("/search-movie/genre")
    public ResponseEntity<Set<Movie>> findByGenre(@RequestParam String genre) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(iMovieService.findByMovieGenre(genre));
    }

    @Override
    @GetMapping("/search-movie/date")
    public ResponseEntity<Set<Movie>> findByDate(@RequestParam String date) {
        return new ResponseEntity<>(iMovieService.findByDate(date), HttpStatus.OK);
    }
}
