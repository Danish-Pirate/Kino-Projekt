package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingByPhoneNumberContainsOrderByDate(String phoneNumber);
    List<Booking> findBookingByShowingDateAndMovieName(Date date, String name);
}
