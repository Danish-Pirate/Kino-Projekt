package group3.kino.movieSearch.service;

import group3.kino.movieAdministration.model.Movie;

import java.util.Set;

public interface IMovieService {
    public Set<Movie> findByTitle(String title);
    public Set<Movie> findByGenre(String genre);
    public Set<Movie> findByDate(String date);
}
