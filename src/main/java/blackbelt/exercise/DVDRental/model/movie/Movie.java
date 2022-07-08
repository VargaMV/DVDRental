package blackbelt.exercise.DVDRental.model.movie;

import javax.persistence.*;

@Entity
@Table(name = "movie")
abstract public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    /**
     * Different type of movies have different price codes.
     */
    private int priceCode;

    public Movie(){}

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public long getId() {
        return id;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Calculates the price of a rental based on the duration.
     * @param daysRented duration of the rental
     * @return price of the rental
     */
    abstract public double calculateAmount(int daysRented);

    /**
     * Calculates how many extra points can a customer get based on the duration of a rental.
     * It is 0 by default, but some types of movies may reward the customer with extra points.
     * @param daysRented
     * @return
     */
    public int calculateExtraRenterPoints(int daysRented) {
        return 0;
    }
}
