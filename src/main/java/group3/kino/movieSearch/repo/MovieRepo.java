package group3.kino.movieSearch.repo;

import group3.kino.movieAdministration.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    Set<Movie> findByNameContainsOrderByDate(String name);
    Set<Movie> findByMovieGenreOrderByDate(String movieGenre);
    Set<Movie> findMovieByDate(String date);
    Set<Movie> findMovieByName(String name);
    Movie findMovieByMovieId(Long id);
}
