package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.service.CalendarService;
import group3.kino.bookingManager.service.ICalendarService;
import group3.kino.movieAdministration.model.Movie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/booking-search")
    public ResponseEntity<List<Booking>> getBookingsByPhoneNumber(@RequestParam String phoneNumber) {
        return new ResponseEntity<>(calendarService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
    @GetMapping("/booking-search/movies_by_showing_date")
    public ResponseEntity<Set<Movie>> getMoviesByDate (@RequestParam String showingDate) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(calendarService.findMovieByShowingDate(showingDate));
    }
    @GetMapping("/booking-search/bookings_by_movie_name_and_date")
    public ResponseEntity<List<Booking>> getBookingsByDateAndMovieName(@RequestParam String date, @RequestParam String name) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(calendarService.findBookingByShowingDateAndMovieName(date, name));
    }
}
