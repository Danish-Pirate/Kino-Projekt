package group3.kino.bookingManager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int numberOfSeats;

    @OneToMany(mappedBy = "cinemaHall")
    private Set<cinemaShow>shows=new HashSet<>();


}
