package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucm.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
