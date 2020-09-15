package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.Safety;

@Repository
public interface SafetyRepository extends JpaRepository<Safety, Long> {
}
