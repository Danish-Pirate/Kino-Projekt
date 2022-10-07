package group3.kino.movieAdministration.controller;

import group3.kino.movieAdministration.model.Movie;
import group3.kino.movieAdministration.service.MovieAdminService;
import group3.kino.util.TokenAuthenticator;
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
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(movieAdminService.findById(id).get(), HttpStatus.OK);
    }

   @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie, @RequestHeader("token") int key) {
       if (!TokenAuthenticator.isTokenAuthenticated(key))
           return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
       return new ResponseEntity<>(movieAdminService.save(movie), HttpStatus.OK);
    }

    @GetMapping("/getAllMovie")
    public ResponseEntity<Set<Movie>> getAllMovie(@RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(movieAdminService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/editMovie/{movieId}")
    public ResponseEntity<Movie> editFilm(@RequestBody Movie newMovie, @PathVariable() Long movieId, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

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
    public ResponseEntity<HttpStatus> deleteFilmByID(@PathVariable("movieId") Long movieId, @RequestHeader("token") int key) {
        if (!TokenAuthenticator.isTokenAuthenticated(key))
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        movieAdminService.deleteById(movieId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
