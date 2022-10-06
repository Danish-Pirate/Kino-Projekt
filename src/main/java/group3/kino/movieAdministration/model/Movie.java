package group3.kino.movieAdministration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

}
