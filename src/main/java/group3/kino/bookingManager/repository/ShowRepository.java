package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.CinemaShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Set;

public interface ShowRepository extends JpaRepository<CinemaShow, Long> {
    Set<CinemaShow> findCinemaShowByDate(Date date);
    Set<CinemaShow> findCinemaShowByDateAndMovieMovieId(String showingDate,Long id);
}
