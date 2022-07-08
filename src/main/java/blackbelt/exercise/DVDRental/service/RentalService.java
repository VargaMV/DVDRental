package blackbelt.exercise.DVDRental.service;

import blackbelt.exercise.DVDRental.db.RentalDataAccess;
import blackbelt.exercise.DVDRental.db.RentalEntity;
import blackbelt.exercise.DVDRental.model.Rental;
import blackbelt.exercise.DVDRental.model.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Connects to the rental database and serves requests related to rentals.
 */
@Service
public class RentalService {

    @Autowired
    private RentalDataAccess rentalDataAccess;

    @Autowired
    private MovieService movieService;

    /**
     * Finds the rental entity with the given id and then finds the corresponding movie as well.
     * Creates a rental object from the found data.
     * @param id unique identifier for a rental
     * @return requested rental
     * @throws NoSuchElementException - if there is no rental with the given id or there is no movie with the stored id
     */
    public Rental getRentalById(Long id) throws NoSuchElementException {
        RentalEntity rentalEntity = this.rentalDataAccess.findById(id).orElseThrow();
        Movie movie = movieService.getMovieById(rentalEntity.getMovieId());
        return new Rental(movie, rentalEntity.getDaysRented());
    }

}
