package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;
import group3.kino.movieAdministration.model.Movie;

import java.util.List;
import java.util.Set;

public interface ICalendarService {
        List<Booking> findByPhoneNumber(String phoneNumber);
        List<Booking> findBookingByShowingDateAndMovieName(String date, String name);
        Set<Movie> findMovieByShowingDate(String showingDate);
}
