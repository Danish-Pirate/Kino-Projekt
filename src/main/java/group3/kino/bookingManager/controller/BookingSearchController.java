package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.service.BookingSearchService;
import group3.kino.bookingManager.service.IBookingSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingSearchController {
    private IBookingSearchService service;

    public BookingSearchController(BookingSearchService service) {
        this.service = service;
    }

    @GetMapping("/booking-search")
    public ResponseEntity<List<Booking>> getBookingByPhoneNumber(@RequestParam String phoneNumber) {
        return new ResponseEntity<>(service.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
}
