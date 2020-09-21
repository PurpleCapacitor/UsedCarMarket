package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucm.models.Extras;

import java.util.List;

@Repository
public interface ExtrasRepository extends JpaRepository<Extras, Long> {

}
