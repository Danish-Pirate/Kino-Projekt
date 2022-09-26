package group3.kino.service;

import group3.kino.model.IMovie;
import group3.kino.repo.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MovieService implements IMovieService{
    private MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
    @Override
    public Optional<IMovie> findByTitle(String title) {
        return movieRepo.findByTitle(title);
    }

    @Override
    public Optional<IMovie> findByGenre(String genre) {
        return movieRepo.findByGenre(genre);
    }

    @Override
    public Optional<IMovie> findByDate(String date) {
        return movieRepo.findByDate(date);
    }
}
