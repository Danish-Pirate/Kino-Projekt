package group3.kino.repo;

import group3.kino.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    Optional<Movie> findByTitle(String title);
    Optional<Movie> findByGenre(String genre);
    Optional<Movie> findByDate(String date);
}
