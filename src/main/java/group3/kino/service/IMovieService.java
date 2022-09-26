package group3.kino.service;

import group3.kino.model.IMovie;

import java.util.Optional;

public interface IMovieService {
    public Optional<IMovie> findByTitle(String title);
    public Optional<IMovie> findByGenre(String genre);
    public Optional<IMovie> findByDate(String date);
}
