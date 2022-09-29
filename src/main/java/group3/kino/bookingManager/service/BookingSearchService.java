package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.repository.BookingSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingSearchService implements IBookingSearchService{
    private BookingSearchRepository repo;

    public BookingSearchService(BookingSearchRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Booking> findByPhoneNumber(String phoneNumber) {
        return repo.findBookingByPhoneNumberContainsOrderByDate(phoneNumber);
    }
}
