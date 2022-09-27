package group3.kino.controller;

import group3.kino.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface iMovieController {
    public ResponseEntity<List<Movie>> findByTitle(String title);
    public ResponseEntity<List<Movie>> findByGenre(String genre);
    public ResponseEntity<List<Movie>> findByDate(String date);
}
