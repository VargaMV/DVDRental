package blackbelt.exercise.DVDRental;

import blackbelt.exercise.DVDRental.db.MovieDataAccess;
import blackbelt.exercise.DVDRental.db.RentalDataAccess;
import blackbelt.exercise.DVDRental.db.RentalEntity;
import blackbelt.exercise.DVDRental.model.Rental;
import blackbelt.exercise.DVDRental.model.movie.ChildrenMovie;
import blackbelt.exercise.DVDRental.model.movie.Movie;
import blackbelt.exercise.DVDRental.model.movie.NewMovie;
import blackbelt.exercise.DVDRental.model.movie.RegularMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Saves some data to the database in order to make the application's basic functionalities testable.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    RentalDataAccess rentalRepository;

    @Autowired
    MovieDataAccess movieRepository;

    @Override
    public void run(String... args) throws Exception {
        rentalRepository.deleteAll();
        movieRepository.deleteAll();

        Movie movie1 = new RegularMovie("Intouchables");
        movieRepository.save(movie1);
        rentalRepository.save(new RentalEntity(new Rental(movie1, 5)));

        Movie movie2 = new RegularMovie("Avengers");
        movieRepository.save(movie2);
        rentalRepository.save(new RentalEntity(new Rental(movie2, 1)));

        Movie movie3 = new NewMovie("Doctor Strange in the Multiverse of Madness");
        movieRepository.save(movie3);
        rentalRepository.save(new RentalEntity(new Rental(movie3, 3)));

        Movie movie4 = new ChildrenMovie("Tangled");
        movieRepository.save(movie4);
        rentalRepository.save(new RentalEntity(new Rental(movie4, 11)));
    }
}
