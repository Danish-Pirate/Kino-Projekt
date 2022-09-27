package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Showing, Long> {
}
