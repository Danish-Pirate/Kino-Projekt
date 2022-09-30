package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.model.CinemaShow;
import group3.kino.bookingManager.repository.CalendarRepository;
import group3.kino.bookingManager.repository.ShowRepository;
import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieSearch.repo.MovieRepo;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CalendarService implements ICalendarService {
    private CalendarRepository calendarRepository;
    private ShowRepository showRepository;
    private MovieRepo movieRepository;

    public CalendarService(CalendarRepository repo, ShowRepository showRepository, MovieRepo movieRepository) {
        this.calendarRepository = repo;
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Booking> findByPhoneNumber(String phoneNumber) {
        return calendarRepository.findBookingByPhoneNumberContainsOrderByDate(phoneNumber);
    }
    @Override
    public List<Booking> findBookingByShowingDateAndMovieName(String date, String name) {
        Date parsedDate= null;
        try {
            parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return calendarRepository.findBookingByShowingDateAndMovieName(parsedDate, name);
    }

    @Override
    public Set<Movie> findMovieByShowingDate(String date) {
        Date parsedDate= null;
        try {
            parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // Gets a list of movies based on the movie showings on the date.
        Set<CinemaShow> listOfShowings = showRepository.findCinemaShowByDate(parsedDate);
        Set<Movie> listOfMovies = new HashSet<>();
        for (CinemaShow cinemaShow: listOfShowings) {
            listOfMovies.add(movieRepository.findMovieByMovieId(cinemaShow.getMovie().getMovieId()));
        }
        return listOfMovies;
    }
}
