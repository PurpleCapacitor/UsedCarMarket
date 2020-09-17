package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.Ad;
import ucm.models.User;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ad, Long> {

    List<Ad> findByUser(User user);
}
