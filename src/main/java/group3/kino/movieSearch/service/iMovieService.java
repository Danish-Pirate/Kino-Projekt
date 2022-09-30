package group3.kino.movieSearch.service;

import group3.kino.movieAdministration.model.Movie;

import java.util.Set;

public interface iMovieService {
    public Set<Movie> findByName(String name);
    public Set<Movie> findByMovieGenre(String genre);
    public Set<Movie> findByDate(String date);
}
