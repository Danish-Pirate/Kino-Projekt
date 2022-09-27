package group3.kino.controller;

import group3.kino.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface iMovieController {
    public ResponseEntity<Set<Movie>> findByTitle(String title);
    public ResponseEntity<Set<Movie>> findByGenre(String genre);
    public ResponseEntity<Set<Movie>> findByDate(String date);
}
