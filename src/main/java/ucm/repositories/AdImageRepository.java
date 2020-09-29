package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.AdImage;

import java.util.Optional;

@Repository
public interface AdImageRepository extends JpaRepository<AdImage, Long> {
    AdImage findByName(String name);
}
