package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;
import group3.kino.bookingManager.model.CinemaHall;
import group3.kino.bookingManager.repository.CinemaHallRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CinemaHallService implements ICinemaHallService{

    private CinemaHallRepository cinemaHallRepository;

    public CinemaHallService(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public Set<CinemaHall> findAll() {
        Set<CinemaHall> set = new HashSet<>();
        cinemaHallRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public CinemaHall save(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public void delete(CinemaHall cinemaHall) {
        cinemaHallRepository.delete(cinemaHall);

    }

    @Override
    public void deleteById(Long aLong) {
        cinemaHallRepository.deleteById(aLong);

    }

    @Override
    public Optional<CinemaHall> findById(Long aLong) {
        return cinemaHallRepository.findById(aLong);
    }
}
