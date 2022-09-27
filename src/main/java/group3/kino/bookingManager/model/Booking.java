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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JsonBackReference("booking")
    @EqualsAndHashCode.Exclude
    private Showing showing;


    @OneToMany(mappedBy = "booking")
    private Set<Seat> bookedSeats=new HashSet<>();


}
