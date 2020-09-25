package ucm.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ucm.inputs.CarModelInput;
import ucm.inputs.ExtrasInput;
import ucm.models.Ad;
import ucm.models.Extras;
import ucm.models.User;
import ucm.repositories.*;
import ucm.specifications.AdSpecification;
import ucm.specifications.AdSpecification.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static ucm.specifications.AdSpecification.*;

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

    public List<Ad> getAds(CarModelInput carModelInput, ExtrasInput extrasInput, int price) {

        List<Ad> adsCarModels = adsRepository.findByCarModelMake(carModelInput.getMake(), carModelInput.getModel(),
                carModelInput.getYear(), carModelInput.getKilometers());

        if (extrasInput != null) {
            if(extrasInput.isBluetooth() || extrasInput.isCruiseControl() || extrasInput.isElectricalMirrors() ||
            extrasInput.isElectricalSeats() || extrasInput.isElectricalWindows() || extrasInput.isHeatedSeats() ||
            extrasInput.isLedHeadlights() || extrasInput.isMultifunctionalSteeringWheel()) {
                List<Ad> adsExtras = adsRepository.findAll(withCruiseControl(extrasInput.isCruiseControl())
                        .and(withElectricalMirrors(extrasInput.isElectricalMirrors()))
                        .and(withElectricalSeats(extrasInput.isElectricalSeats()))
                        .and(withElectricalWindows(extrasInput.isElectricalWindows()))
                        .and(withMultifunctionalSteeringWheel(extrasInput.isMultifunctionalSteeringWheel()))
                        .and(withBluetooth(extrasInput.isBluetooth()))
                        .and(withHeatedSeats(extrasInput.isHeatedSeats()))
                        .and(withLedHeadlights(extrasInput.isLedHeadlights())));
                if (!adsExtras.isEmpty()) {
                    adsCarModels.retainAll(adsExtras);
                }
            }

        }

        if (price != 0) {
            List<Ad> prices = adsRepository.findByPrice(price);
            adsCarModels.retainAll(prices);
        }
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
