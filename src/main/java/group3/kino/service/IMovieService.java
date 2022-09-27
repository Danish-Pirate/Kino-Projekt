package group3.kino.service;

import group3.kino.model.Movie;

import java.util.Optional;

public interface IMovieService {
    public Optional<Movie> findByTitle(String title);
    public Optional<Movie> findByGenre(String genre);
    public Optional<Movie> findByDate(String date);
}
