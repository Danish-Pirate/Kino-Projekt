package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Seat;
import group3.kino.bookingManager.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SeatService implements ISeatService{

    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Set<Seat> findAll() {
        Set<Seat> set = new HashSet<>();
        seatRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void delete(Seat seat) {
        seatRepository.delete(seat);

    }

    @Override
    public void deleteById(Long aLong) {
        seatRepository.deleteById(aLong);

    }

    @Override
    public Optional<Seat> findById(Long aLong) {
        return seatRepository.findById(aLong);
    }
}
