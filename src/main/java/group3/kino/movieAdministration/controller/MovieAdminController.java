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

    @Autowired
    private MovieAdminService movieAdminService;

    public MovieAdminController(MovieAdminService movieAdminService) {
        this.movieAdminService = movieAdminService;
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
    @PutMapping("/editMovie")
    public ResponseEntity<Movie> editFilm(@RequestBody Movie newMovie, @RequestParam String movieName){
        Optional<Movie> oldMovie = movieAdminService.findByName(movieName);
        if (oldMovie.isPresent()){
            movieAdminService.save(newMovie);

            return new ResponseEntity<>(newMovie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(newMovie, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/deleteMovie")
    public ResponseEntity<Movie> deleteFilm(String name){
        Optional<Movie> movie = movieAdminService.findByName(name);
        if (movie.isPresent()){
            Movie movie_ = movie.get();
            movieAdminService.delete(movie);

            return new ResponseEntity<>(movie_, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
