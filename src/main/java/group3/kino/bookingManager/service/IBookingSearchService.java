package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;
import group3.kino.movieAdministration.model.Movie;

import java.util.List;
import java.util.Set;

public interface IBookingSearchService {
        List<Booking> findByPhoneNumber(String phoneNumber);
        List<Booking> findByDateAndName(String date, String name);
        Set<Movie> findMovieByDate(String date);
}
