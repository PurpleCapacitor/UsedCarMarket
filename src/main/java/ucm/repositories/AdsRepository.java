package ucm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucm.models.Ad;
import ucm.models.User;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ad, Long> {

    List<Ad> findByUser(User user);

    @Query("select ad from Ad ad inner join CarModel c on ad.carModel.id = c.id" +
            " where (:make is null or c.make = :make)" +
            " and (:model is null or c.model = :model) and (:year is null or c.year = :year)" +
            " and (:kilometers = 0 or c.kilometers = :kilometers)")
    List<Ad> findByCarModelMake(@Param("make") String make,
                                @Param("model") String model,
                                @Param("year") String year,
                                @Param("kilometers") int kilometers);

    @Query("select ad from Ad ad inner join Extras e on ad.extras.id = e.id" +
            " where e.cruiseControl = :cc" +
            " and e.electricalMirrors = :em" +
            " and e.electricalSeats = :es and e.electricalWindows = :ew" +
            " and e.multifunctionalSteeringWheel = :mfsw and e.bluetooth = :bt" +
            " and e.ledHeadlights = :lh and e.heatedSeats = :hs")
    List<Ad> findByExtras(
            @Param("cc") boolean cc, @Param("em") boolean em, @Param("es") boolean es, @Param("ew") boolean ew,
            @Param("mfsw") boolean mfsw, @Param("bt") boolean bt, @Param("lh") boolean lh, @Param("hs") boolean hs);
}
