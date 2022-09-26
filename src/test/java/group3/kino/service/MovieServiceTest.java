package group3.kino.service;

import group3.kino.model.IMovie;
import group3.kino.repo.MovieRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    @MockBean
    private MovieRepo movieRepo;

    @BeforeEach
    public void beforeEach() {
        movieService = new MovieService(movieRepo);
    }

    @BeforeAll
    public void beforeAll() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Shrek", "Madagascar", "Castaway"})
    public void movieservice_SearchMovieByName(String value) {
        Optional<IMovie> movieList = movieService.findByTitle(value);
        for (IMovie movie: movieList.stream().toList()) {
            Assertions.assertEquals(movie.getTitle(), value);
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"Horror", "Comedy", "Drama"})
    public void movieservice_SearchMovieByGenre(String value) {
        Optional<IMovie> movieList = movieService.findByGenre(value);
        for (IMovie movie: movieList.stream().toList()) {
            Assertions.assertEquals(movie.getGenre(), value);
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"2022-12-24", "2022-11-12", "2020-05-27"})
    public void movieservice_SearchMovieByDate(String value) {
        Optional<IMovie> movieList = movieService.findByDate(value);
        for (IMovie movie: movieList.stream().toList()) {
            Assertions.assertEquals(movie.getDate(), value);
        }
    }
}
