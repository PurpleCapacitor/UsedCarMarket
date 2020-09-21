package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucm.models.Bla;

import java.util.List;

@Repository
public interface BlaRepository extends JpaRepository<Bla, Long> {

    @Query("select b from Bla b where (:name is null or b.name = :name) and " +
            "(:address is null or b.address = :address)" +
            "and (:color is null or b.color = :color)")
    List<Bla> findByNameOrAddressOrColor(String name, String address, String color);

}
