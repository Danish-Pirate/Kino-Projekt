package group3.kino.repository;

import group3.kino.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieAdminRepo extends JpaRepository<Movie, Long> {

    List<Movie> findFilmByName(String name);



}
