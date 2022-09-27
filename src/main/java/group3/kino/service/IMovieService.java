package group3.kino.service;

import group3.kino.model.Movie;

import java.util.Set;

public interface IMovieService {
    public Set<Movie> findByTitle(String title);
    public Set<Movie> findByGenre(String genre);
    public Set<Movie> findByDate(String date);
}
