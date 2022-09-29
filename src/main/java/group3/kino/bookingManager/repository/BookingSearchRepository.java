package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.Booking;
import group3.kino.movieAdministration.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingSearchRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingByPhoneNumberContainsOrderByDate(String phoneNumber);
    List<Booking> findBookingByDateAndMovieName(String date, String name);
}
