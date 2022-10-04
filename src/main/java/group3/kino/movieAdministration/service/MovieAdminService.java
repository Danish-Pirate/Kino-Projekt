package group3.kino.movieAdministration.service;

import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieAdministration.repository.MovieAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieAdminService implements IMovieAdminService {

    private MovieAdminRepo movieAdminRepo;
    @Autowired
    public MovieAdminService(MovieAdminRepo movieAdminRepo) {
        this.movieAdminRepo = movieAdminRepo;
    }

    public MovieAdminService() {

    }

    @Override
    public Set<Movie> findAll() {
        Set<Movie> set = new HashSet<>(movieAdminRepo.findAll());
        return set;
    }

    @Override
    public Movie save(Movie object) {
        return movieAdminRepo.save(object);
    }

    @Override
    public void delete(Optional<Movie> object) {

    }

    @Override
    public void deleteById(Long id) {
        movieAdminRepo.deleteById(id);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieAdminRepo.findById(id);
    }

    public Optional<Movie> findByName(String name) {
        return Optional.empty();
    }
}

