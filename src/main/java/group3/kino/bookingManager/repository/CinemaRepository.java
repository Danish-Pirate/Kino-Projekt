package group3.kino.bookingManager.repository;


import group3.kino.bookingManager.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
