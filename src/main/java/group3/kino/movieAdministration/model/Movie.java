package group3.kino.movieAdministration.model;

import group3.kino.bookingManager.model.CinemaShow;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String name;
    private String date;
    private double movieLength;
    private String movieGenre;
    private int movieAgeRestriction;
    private double moviePrice;
    private String posterLink;

    @OneToMany(mappedBy = "movie")
    private Set<CinemaShow> cinemaShows = new HashSet<>();


    public void addCinemaShow(CinemaShow cinemaShow){
        this.cinemaShows.add(cinemaShow);
    }

}
