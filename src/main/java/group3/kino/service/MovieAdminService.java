package group3.kino.service;

import group3.kino.model.Movie;
import group3.kino.repository.MovieAdminRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieAdminService implements IMovieAdminService {

    private MovieAdminRepo movieAdminRepo;

    public MovieAdminService(MovieAdminRepo movieAdminRepo) {
        this.movieAdminRepo = movieAdminRepo;
    }

    @Override
    public Set<Movie> findAll() {
        Set<Movie> set = new HashSet<>();
        movieAdminRepo.findAll();
        return set;
    }

    @Override
    public Movie save(Movie object) {
        return null;
    }

    @Override
    public void delete(Optional<Movie> object) {

    }

    @Override
    public void deleteById(Long Id) {

    }

    @Override
    public Optional<Movie> findById(Long Id) {
        return Optional.empty();
    }

    public Optional<Movie> findByName(String name) {
        return Optional.empty();
    }
}

