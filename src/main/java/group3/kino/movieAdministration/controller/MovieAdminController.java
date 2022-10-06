package group3.kino.movieAdministration.controller;

import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieAdministration.service.MovieAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class MovieAdminController {

    private MovieAdminService movieAdminService;
@Autowired
    public MovieAdminController(MovieAdminService movieAdminService) {
        this.movieAdminService = movieAdminService;
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        movieAdminService.findById(id);
        return new ResponseEntity<>(movieAdminService.findById(id).get(), HttpStatus.OK);
    }

   @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        movieAdminService.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/getAllMovie")
    public ResponseEntity<Set<Movie>> getAllMovie() {
        return new ResponseEntity<>(movieAdminService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/editMovie/{movieId}")
    public ResponseEntity<Movie> editFilm(@RequestBody Movie newMovie, @PathVariable() Long movieId) {
        System.out.println("Film: "+newMovie.getName() + " \tId: " + movieId);
        Optional<Movie> oldMovie = movieAdminService.findById(movieId);
        if (oldMovie.isPresent()) {
            movieAdminService.save(newMovie);
            return new ResponseEntity<>(newMovie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(newMovie, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteFilm/{movieId}")
    public void deleteFilmByID(@PathVariable("movieId") Long movieId) {
        movieAdminService.deleteById(movieId);
    }

}
