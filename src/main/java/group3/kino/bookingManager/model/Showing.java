package group3.kino.bookingManager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp dateAndTime;

    private String movie;

    @ManyToOne
    @JsonBackReference("cinemaHall")
    @EqualsAndHashCode.Exclude
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "showing")
    private Set<Booking> bookings=new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "seat_showing",
            joinColumns = @JoinColumn(name = "showing_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    @JsonBackReference("seats")
    private Set<Seat>bookedSeats=new HashSet<>();

}