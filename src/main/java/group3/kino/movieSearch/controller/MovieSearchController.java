package group3.kino.movieSearch.controller;

import group3.kino.movieAdministration.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MovieSearchController implements iMovieController{
    @Override
    public ResponseEntity<Set<Movie>> findByTitle(String title) {
        return null;
    }

    @Override
    public ResponseEntity<Set<Movie>> findByGenre(String genre) {
        return null;
    }

    @Override
    public ResponseEntity<Set<Movie>> findByDate(String date) {
        return null;
    }
}
