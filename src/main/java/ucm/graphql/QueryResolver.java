package ucm.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ucm.inputs.CarModelInput;
import ucm.inputs.ExtrasInput;
import ucm.models.Ad;
import ucm.models.User;
import ucm.repositories.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
@Transactional
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private AdsRepository adsRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExtrasRepository extrasRepository;
    @Autowired
    private CharacteristicsRepository characteristicsRepository;
    @Autowired
    private BlaRepository blaRepository;

//    public List<Ad> getAds() {
//        return adsRepository.findAll();
//    }

    public List<Ad> getAds(CarModelInput carModelInput, ExtrasInput extrasInput) {

        List<Ad> adsCarModels = adsRepository.findByCarModelMake(carModelInput.getMake(), carModelInput.getModel(),
                carModelInput.getYear(), carModelInput.getKilometers());

        List<Ad> adsExtras = adsRepository.findByExtras(
                extrasInput.isCruiseControl(),
                extrasInput.isElectricalMirrors(),
                extrasInput.isElectricalSeats(),
                extrasInput.isElectricalWindows(),
                extrasInput.isMultifunctionalSteeringWheel(),
                extrasInput.isBluetooth(),
                extrasInput.isLedHeadlights(),
                extrasInput.isHeatedSeats()
        ); //todo pisi specifikaciju za to

        adsCarModels.retainAll(adsExtras);
        return adsCarModels;
    }

    public Ad getAd(Long id) {
        return adsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Ad> getUserAds(String username) {
        User user = userRepository.findByUsername(username);
        return adsRepository.findByUser(user);
    }
}
