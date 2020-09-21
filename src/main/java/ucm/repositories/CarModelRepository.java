package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucm.models.CarModel;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findByMake(String make);
    /*@Query("select c from CarModel c where (:make is null or c.make = :make) and" +
            "(:model is null or c.model = :model) and (:year is null or c.year = :year)" +
            "and (:kilometers = 0 or c.kilometers = :kilometers)")*/
    List<CarModel> findByMakeAndModelAndYearAndKilometers(String make, String model, String year, int kilometers);
    
}
