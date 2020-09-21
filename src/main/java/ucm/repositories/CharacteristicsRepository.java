package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.Characteristics;

import java.util.List;

@Repository
public interface CharacteristicsRepository extends JpaRepository<Characteristics, Long> {

    List<Characteristics> findByAcTrue();
}
