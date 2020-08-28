package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.CarModel;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
