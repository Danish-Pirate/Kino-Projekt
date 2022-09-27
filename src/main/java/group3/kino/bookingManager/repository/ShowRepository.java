package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.cinemaShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<cinemaShow, Long> {
}
