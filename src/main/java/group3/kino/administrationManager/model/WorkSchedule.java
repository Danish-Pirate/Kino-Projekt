package group3.kino.administrationManager.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class WorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonSerialize
    private String title;

    @JsonSerialize
    private LocalDateTime start;

    @JsonSerialize
    private LocalDateTime end;

    @JsonSerialize
    private String type;

}
