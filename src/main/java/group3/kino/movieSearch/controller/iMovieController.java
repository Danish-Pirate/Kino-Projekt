package group3.kino.movieSearch.controller;

import group3.kino.movieAdministration.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface iMovieController {
    public ResponseEntity<Set<Movie>> findByName(String name, int key);
    public ResponseEntity<Set<Movie>> findByGenre(String genre, int key);
    public ResponseEntity<Set<Movie>> findByDate(String date, int key);
}
