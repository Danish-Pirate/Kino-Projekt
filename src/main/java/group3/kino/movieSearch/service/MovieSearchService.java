package group3.kino.movieSearch.service;

import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieSearch.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MovieSearchService implements iMovieService {
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public Set<Movie> findByName(String name) {
        return movieRepo.findByName(name);
    }

    @Override
    public Set<Movie> findByMovieGenre(String movieGenre) {
        return movieRepo.findByMovieGenre(movieGenre);
    }

    @Override
    public Set<Movie> findByDate(String date) {
        return movieRepo.findByDate(date);
    }
}
