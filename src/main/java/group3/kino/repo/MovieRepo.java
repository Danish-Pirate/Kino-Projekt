package group3.kino.repo;

import group3.kino.model.IMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<IMovie, Long> {
    Optional<IMovie> findByTitle(String title);
    Optional<IMovie> findByGenre(String genre);
    Optional<IMovie> findByDate(String date);
}
