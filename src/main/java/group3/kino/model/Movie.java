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
    @Column(name = "movieName", nullable = false)
    private String movieName;
    @Column
    private double movieLength;
    @Column
    private String movieGenre;
    @Column
    private int movieAgeRestriction;
    @Column
    private double moviePrice;

}
