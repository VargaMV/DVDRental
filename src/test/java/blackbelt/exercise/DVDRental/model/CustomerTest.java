package blackbelt.exercise.DVDRental.model;

import blackbelt.exercise.DVDRental.model.movie.ChildrenMovie;
import blackbelt.exercise.DVDRental.model.movie.Movie;
import blackbelt.exercise.DVDRental.model.movie.NewMovie;
import blackbelt.exercise.DVDRental.model.movie.RegularMovie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateStatementTest1() {
        Customer arnold = new Customer("Arnold");

        Movie movie1 = new RegularMovie("The Prestige");
        Movie movie2 = new NewMovie("Thor: Love and Thunder");
        Movie movie3 = new ChildrenMovie("Encanto");

        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 2);
        Rental rental3 = new Rental(movie3, 7);

        arnold.addRental(rental1);
        arnold.addRental(rental2);
        arnold.addRental(rental3);

        String statement = arnold.generateStatement();
        String[] statementParts = statement.split("\n");

        String[] firstMovieInfo = statementParts[1].strip().split("\t");
        assertEquals(firstMovieInfo[0], movie1.getTitle());
        assertEquals(Double.parseDouble(firstMovieInfo[1].strip()), 14.0);

        String[] secondMovieInfo = statementParts[2].strip().split("\t");
        assertEquals(secondMovieInfo[0], movie2.getTitle());
        assertEquals(Double.parseDouble(secondMovieInfo[1].strip()), 6.0);

        String[] thirdMovieInfo = statementParts[3].strip().split("\t");
        assertEquals(thirdMovieInfo[0], movie3.getTitle());
        assertEquals(Double.parseDouble(thirdMovieInfo[1].strip()), 7.5);

        String[] allAmountInfo = statementParts[4].strip().split(" ");
        assertEquals(Double.parseDouble(allAmountInfo[3]), 27.5);

        String[] renterPointsInfo = statementParts[5].strip().split(" ");
        assertEquals(Integer.parseInt(renterPointsInfo[2]), 4);

    }

    @Test
    void generateStatementTest2() {
        Customer bess = new Customer("Bess");

        Movie movie1 = new RegularMovie("Inception");
        Movie movie2 = new ChildrenMovie("Frozen");

        Rental rental1 = new Rental(movie1, 2);
        Rental rental2 = new Rental(movie2, 3);

        bess.addRental(rental1);
        bess.addRental(rental2);

        String statement = bess.generateStatement();
        String[] statementParts = statement.split("\n");

        String[] firstMovieInfo = statementParts[1].strip().split("\t");
        assertEquals(firstMovieInfo[0], movie1.getTitle());
        assertEquals(Double.parseDouble(firstMovieInfo[1].strip()), 2.0);

        String[] secondMovieInfo = statementParts[2].strip().split("\t");
        assertEquals(secondMovieInfo[0], movie2.getTitle());
        assertEquals(Double.parseDouble(secondMovieInfo[1].strip()), 1.5);

        String[] allAmountInfo = statementParts[3].strip().split(" ");
        assertEquals(Double.parseDouble(allAmountInfo[3]), 3.5);

        String[] renterPointsInfo = statementParts[4].strip().split(" ");
        assertEquals(Integer.parseInt(renterPointsInfo[2]), 2);

    }
}