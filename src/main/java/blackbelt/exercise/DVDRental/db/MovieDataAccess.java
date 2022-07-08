package blackbelt.exercise.DVDRental.db;

import blackbelt.exercise.DVDRental.model.movie.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDataAccess extends CrudRepository<Movie, Long> {

}
