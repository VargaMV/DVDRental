package blackbelt.exercise.DVDRental.model.movie;

import javax.persistence.Entity;

/**
 * Movies that are released recently.
 */
@Entity
public class NewMovie extends Movie{

    public NewMovie(){
        super();
    }

    public NewMovie(String title){
        super(title, 1);
    }

    @Override
    public double calculateAmount(int daysRented) {
        double amount = daysRented * 3;
        return amount;
    }

    @Override
    public int calculateExtraRenterPoints(int daysRented) {
        return daysRented > 1 ? 1 : 0;
    }
}
