package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.Condition;
@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
}
