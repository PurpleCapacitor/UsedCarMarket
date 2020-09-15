package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.Extras;

@Repository
public interface ExtrasRepository extends JpaRepository<Extras, Long> {
}
