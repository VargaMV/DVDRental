package blackbelt.exercise.DVDRental.service;

import blackbelt.exercise.DVDRental.db.MovieDataAccess;
import blackbelt.exercise.DVDRental.model.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Connects to the movie database and serves requests related to movies.
 */
@Service
public class MovieService {

    @Autowired
    private MovieDataAccess movieDataAccess;

    /**
     * Finds the movie with the given id.
     * @param id unique identifier for a movie
     * @return requested movie
     * @throws NoSuchElementException - if there is no movie with the given id
     */
    public Movie getMovieById(Long id) throws NoSuchElementException {
        return movieDataAccess.findById(id).orElseThrow();
    }

}
