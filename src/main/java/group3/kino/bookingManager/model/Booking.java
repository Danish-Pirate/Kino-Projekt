package group3.kino.bookingManager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String phoneNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;

    private String timeSlot;
    private String cinemaName;
    private String movieName;

    private double totalPrice;

    @ManyToOne
    @JsonBackReference("booking")
    @EqualsAndHashCode.Exclude
    private CinemaShow showing;

    public Booking(){}

    public Booking(String customerName, String phoneNumber, String date, String timeSlot, String cinemaName, String movieName, double totalPrice) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.timeSlot = timeSlot;
        this.cinemaName = cinemaName;
        this.movieName = movieName;
        this.totalPrice = totalPrice;
    }

}
