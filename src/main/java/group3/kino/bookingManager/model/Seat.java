package group3.kino.bookingManager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private int rowNumber;
    private int seatNumber;

    @ManyToOne
    @JsonBackReference("seat_booking")
    @EqualsAndHashCode.Exclude
    private Booking booking;

    @ManyToMany (mappedBy = "bookedSeats")
    @JsonBackReference("bookedSeats")
    private Set<Showing> showings=new HashSet<>();


}
