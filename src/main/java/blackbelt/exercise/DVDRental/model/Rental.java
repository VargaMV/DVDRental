package blackbelt.exercise.DVDRental.model;

import blackbelt.exercise.DVDRental.model.movie.Movie;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(){}

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    /**
     * Calls the correspondent method on the movie which is the rental's subject.
     * @return price of the rental
     */
    public double calculateAmount() {
        return movie.calculateAmount(daysRented);
    }

    /**
     * Calls the correspondent method on the movie which is the rental's subject.
     * @return received renter points
     */
    public int calculateExtraRenterPoints() {
        return movie.calculateExtraRenterPoints(daysRented);
    }
}

