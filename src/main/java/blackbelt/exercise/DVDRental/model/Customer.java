package blackbelt.exercise.DVDRental.model;

import java.util.ArrayList;


public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Adds a new rental to a customer.
     * @param rental    rental information, comprising the rental's duration and some data about the movie
     */
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    /**
     * Returns a "bill" as a String for the given customer based on their rentals.
     * The bill contains the different movie rentals with the corresponding costs.
     * It also contains the total amount and the frequent renter points acquired by the customer.
     * @return  the customer's bill
     */
    public String generateStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ")
                .append(getName())
                .append("\n");
        for (Rental currentRental : rentals) {
            double thisAmount = 0;
            thisAmount += currentRental.calculateAmount();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            frequentRenterPoints += currentRental.calculateExtraRenterPoints();

            // show figures for this rental
            result.append("\t")
                    .append(currentRental.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount)
                    .append("\n");
            totalAmount += thisAmount;
        }

        // add footer lines
        result.append("Amount owed is ")
                .append(totalAmount)
                .append("\n");

        result.append("You earned ")
                .append(frequentRenterPoints)
                .append(" frequent renter points");

        return result.toString();
    }
}
