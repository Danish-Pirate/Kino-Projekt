package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.repository.BookingSearchRepository;
import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieSearch.repo.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookingSearchService implements IBookingSearchService{
    private BookingSearchRepository bookingRepo;
    private MovieRepo movieRepo;

    public BookingSearchService(BookingSearchRepository repo, MovieRepo movieRepo) {
        this.bookingRepo = repo;
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Booking> findByPhoneNumber(String phoneNumber) {
        return bookingRepo.findBookingByPhoneNumberContainsOrderByDate(phoneNumber);
    }
    @Override
    public List<Booking> findByDateAndName(String date, String name) {
        return bookingRepo.findBookingByDateAndMovieName(date, name);
    }

    @Override
    public Set<Movie> findMovieByDate(String date) {
        return movieRepo.findMovieByDate(date);
    }
}
