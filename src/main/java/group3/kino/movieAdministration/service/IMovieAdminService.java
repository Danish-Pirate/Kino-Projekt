package group3.kino.movieAdministration.service;

import group3.kino.movieAdministration.model.Movie;

import java.util.Set;


public interface IMovieAdminService extends CRUD<Movie, Long> {
    public Set<Movie> findByName(String name);
}
