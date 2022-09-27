package group3.kino.movieSearch.repo;

import group3.kino.movieAdministration.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    Set<Movie> findByName(String name);
    Set<Movie> findByMovieGenre(String movieGenre);
    Set<Movie> findByDate(String date);
}
