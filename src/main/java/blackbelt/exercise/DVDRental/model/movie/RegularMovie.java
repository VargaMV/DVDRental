package blackbelt.exercise.DVDRental.model.movie;

import javax.persistence.Entity;

/**
 * Movies with no special feature.
 */
@Entity
public class RegularMovie extends Movie {

    public RegularMovie(){
        super();
    }

    public RegularMovie(String title){
        super(title, 0);
    }

    @Override
    public double calculateAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}
