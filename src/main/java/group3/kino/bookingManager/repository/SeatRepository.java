package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
