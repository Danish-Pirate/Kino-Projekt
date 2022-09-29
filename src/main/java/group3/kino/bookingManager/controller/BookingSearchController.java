package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.service.BookingSearchService;
import group3.kino.bookingManager.service.IBookingSearchService;
import group3.kino.movieAdministration.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class BookingSearchController {
    private IBookingSearchService service;

    public BookingSearchController(BookingSearchService service) {
        this.service = service;
    }

    @GetMapping("/booking-search")
    public ResponseEntity<List<Booking>> getBookingsByPhoneNumber(@RequestParam String phoneNumber) {
        return new ResponseEntity<>(service.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
    @GetMapping("/booking-search/movies_by_date")
    public ResponseEntity<Set<Movie>> getMoviesByDate (@RequestParam String date) {
        return new ResponseEntity<>(service.findMovieByDate(date), HttpStatus.OK);
    }
    @GetMapping("/booking-search/bookings_by_movie_name_and_date")
    public ResponseEntity<List<Booking>> getBookingsByDateAndMovieName(@RequestParam String date, @RequestParam String name) {
        return new ResponseEntity<>(service.findByDateAndName(date, name), HttpStatus.OK);
    }
}
