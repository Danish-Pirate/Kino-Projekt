package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Showing;
import group3.kino.bookingManager.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ShowingService implements IShowingService {

    private ShowRepository showRepository;

    public ShowingService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Set<Showing> findAll() {
        Set<Showing> set = new HashSet<>();
        showRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Showing save(Showing show) {
        return showRepository.save(show);
    }

    @Override
    public void delete(Showing show) {
        showRepository.delete(show);

    }

    @Override
    public void deleteById(Long aLong) {
        showRepository.deleteById(aLong);

    }

    @Override
    public Optional<Showing> findById(Long aLong) {
        return showRepository.findById(aLong);
    }
}
