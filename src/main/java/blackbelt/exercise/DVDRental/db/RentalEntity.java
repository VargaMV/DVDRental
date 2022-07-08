package blackbelt.exercise.DVDRental.db;

import blackbelt.exercise.DVDRental.model.Rental;
import lombok.Data;

import javax.persistence.*;

/**
 * Similar to the Rental class, but the movie field is replaced with a movie id,
 * so that it can be stored in the database.
 */
@Data
@Entity
@Table(name = "rental")
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long movieId;
    private int daysRented;

    public RentalEntity(){}

    public RentalEntity(Rental rental) {
        this.movieId = rental.getMovie().getId();
        this.daysRented = rental.getDaysRented();
    }
}
