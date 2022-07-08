package blackbelt.exercise.DVDRental.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalDataAccess extends CrudRepository<RentalEntity, Long> {

}
