package group3.kino.bookingManager.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String date;
    private String timeSlot;
    private String cinemaName;
    private String movieName;

    private double totalPrice;

    @ManyToOne
    @JsonBackReference("booking")
    @EqualsAndHashCode.Exclude
    private cinemaShow showing;


    @OneToMany(mappedBy = "booking")
    private Set<Seat> seats=new HashSet<>();


}
