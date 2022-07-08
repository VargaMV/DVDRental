package blackbelt.exercise.DVDRental.model.movie;

import javax.persistence.Entity;

/**
 * Movies for kids.
 */
@Entity
public class ChildrenMovie extends Movie{

    public ChildrenMovie(){
        super();
    }

    public ChildrenMovie(String title){
        super(title, 2);
    }

    @Override
    public double calculateAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }
}
