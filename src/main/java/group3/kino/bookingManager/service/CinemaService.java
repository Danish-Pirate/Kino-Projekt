package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Cinema;
import group3.kino.bookingManager.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CinemaService implements ICinemaService {

    private CinemaRepository cinemaHallRepository;

    public CinemaService(CinemaRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public Set<Cinema> findAll() {
        Set<Cinema> set = new HashSet<>();
        cinemaHallRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Cinema save(Cinema cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public void delete(Cinema cinemaHall) {
        cinemaHallRepository.delete(cinemaHall);

    }

    @Override
    public void deleteById(Long aLong) {
        cinemaHallRepository.deleteById(aLong);

    }

    @Override
    public Optional<Cinema> findById(Long aLong) {
        return cinemaHallRepository.findById(aLong);
    }
}
