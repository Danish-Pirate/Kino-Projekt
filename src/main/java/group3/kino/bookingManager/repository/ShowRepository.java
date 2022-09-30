package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.CinemaShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<CinemaShow, Long> {
}
