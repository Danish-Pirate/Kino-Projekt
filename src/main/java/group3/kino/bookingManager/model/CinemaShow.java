package group3.kino.bookingManager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import group3.kino.movieAdministration.model.Movie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class CinemaShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Timestamp time;

    @ManyToOne
    @JsonBackReference("cinemaHall")
    @EqualsAndHashCode.Exclude
    private Cinema cinemaHall;

    @OneToMany(mappedBy = "showing")
    private Set<Booking> bookings=new HashSet<>();

    @ManyToOne
    @JsonBackReference("movies")
    @EqualsAndHashCode.Exclude
    private Movie movie;


}