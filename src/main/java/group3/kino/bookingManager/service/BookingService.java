package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookingService implements IBookingService{

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Set<Booking> findAll() {
        Set<Booking> set = new HashSet<>();
        bookingRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Booking save(Booking object) {
        return bookingRepository.save(object);
    }

    @Override
    public void delete(Booking object) {
        bookingRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        bookingRepository.deleteById(aLong);
    }

    @Override
    public Optional<Booking> findById(Long aLong) {
        return bookingRepository.findById(aLong);
    }
}
