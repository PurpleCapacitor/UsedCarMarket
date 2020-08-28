package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.Ad;

@Repository
public interface AdsRepository extends JpaRepository<Ad, Long> {
}
