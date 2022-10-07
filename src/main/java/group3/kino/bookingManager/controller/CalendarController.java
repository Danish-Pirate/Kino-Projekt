package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.service.CalendarService;
import group3.kino.bookingManager.service.ICalendarService;
import group3.kino.movieAdministration.model.Movie;
import group3.kino.util.TokenAuthenticator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class CalendarController {
    private ICalendarService calendarService;

    public CalendarController(CalendarService service) {
        this.calendarService = service;
    }

    @GetMapping("/booking-search/phone_number")
    public ResponseEntity<List<Booking>> getBookingsByPhoneNumber(@RequestParam String phoneNumber, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(calendarService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
    @GetMapping("/booking-search/showing_date")
    public ResponseEntity<Set<Movie>> getMoviesByDate (@RequestParam String showingDate, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(calendarService.findMovieByShowingDate(showingDate), HttpStatus.OK);
    }
    @GetMapping("/booking-search/showing_date/movie_name")
    public ResponseEntity<List<Booking>> getBookingsByDateAndMovieName(
            @RequestParam String date,
            @RequestParam String name,
            @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(calendarService.findBookingByShowingDateAndMovieName(date, name), HttpStatus.OK);
    }
}
