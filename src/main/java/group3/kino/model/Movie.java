package group3.kino.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String name;
    private double movieLength;
    private String movieGenre;
    private int movieAgeRestriction;
    private double moviePrice;

}
