package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.model.Seat;
import group3.kino.bookingManager.service.BookingService;
import group3.kino.bookingManager.service.SeatService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class BookingController {

    private BookingService bookingService;
    private SeatService seatService;

    public BookingController(BookingService bookingService, SeatService seatService) {
        this.bookingService = bookingService;
        this.seatService = seatService;
    }

    @PostMapping ("/createBooking")
    public   ResponseEntity<String> createBooking(@RequestParam("customerName") String customerName, @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("date") String date, @RequestParam("timeSlot") String timeSlot, @RequestParam("cinemaName") String cinemaName,
                                                  @RequestParam("movieName") String movieName, @RequestParam("totalPrice") double totalPrice)  {
        Booking booking = new Booking(customerName, phoneNumber, date, timeSlot, cinemaName, movieName, totalPrice);
        bookingService.save(booking);
        /* String msg="";
        if(bookingService.save(booking)!=null)  {
            msg="Oprettet booking: " + booking.getMovieName();
        }else {
            msg="fejl i oprettelsen af " + booking.getMovieName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
        */

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("test");
    }

    @GetMapping ("/getAll")
    public ResponseEntity<Set<Booking>> getAllBookings()  {
        return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/editBooking")
    public ResponseEntity<Booking> editBooking(@RequestBody Booking newBooking, @RequestParam Long bookingId)  {
        Optional<Booking> oldBooking_ = bookingService.findById(bookingId);
        if(oldBooking_.isPresent()) {
            newBooking.setId(bookingId);
            bookingService.save(newBooking);
            return new ResponseEntity<>(newBooking, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(newBooking, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteBooking")
    public ResponseEntity<Booking> deleteBooking(Long id) {
        Optional<Booking> booking_ = bookingService.findById(id);
        if(booking_.isPresent())  {
            Booking booking = booking_.get();
            bookingService.deleteById(id);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/showAvailableSeats")
    public ResponseEntity<Set<Seat>> showAvailable()  {
        return new ResponseEntity<>(seatService.findAllAvailable(), HttpStatus.OK);

    }

}
