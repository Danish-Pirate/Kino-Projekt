package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
