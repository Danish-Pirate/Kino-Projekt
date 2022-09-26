package group3.kino.bookingManager.controller;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping ("/createBooking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking)  {
        bookingService.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping ("/getAll")
    public ResponseEntity<Set<Booking>> getAllBookings()  {
        return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/editBooking")
    public ResponseEntity<Booking> editBooking(@RequestBody Booking newBooking, @RequestParam Long bookingId)  {
        Optional<Booking> oldBooking_ = bookingService.findById(bookingId);
        if(oldBooking_.isPresent()) {

            //Booking booking = oldBooking_.get();
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

}
