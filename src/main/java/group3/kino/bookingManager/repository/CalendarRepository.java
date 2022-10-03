package group3.kino.bookingManager.repository;

import group3.kino.bookingManager.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingByPhoneNumberContainsOrderByDate(String phoneNumber);

    @Query(
            value = "SELECT * FROM booking\n" +
                    "inner join cinema_show cs on booking.showing_id = cs.id\n" +
                    "inner join movie m on cs.movie_movie_id = m.movie_id\n" +
                    "WHERE movie_name = ?1 AND cs.date = ?2",
            nativeQuery = true
    )
    List<Booking> findBookingByDateAndMovieName(String movieName, String date);
}
