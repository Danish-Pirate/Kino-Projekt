package group3.kino.candyAdministration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Candy {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long candyId;
        private String candyName;
        private String candySize;
        private String candyAmount;
        private Long candyPrice;
        private String productLink;
    }
