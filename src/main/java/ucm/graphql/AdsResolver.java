package ucm.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucm.models.Ad;
import ucm.models.CarModel;
import ucm.models.User;
import ucm.repositories.AdsRepository;
import ucm.repositories.CarModelRepository;
import ucm.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;

@Component
public class AdsResolver implements GraphQLResolver<Ad> {

    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private UserRepository userRepository;

    public CarModel getCarModel(Ad ad) {
        return carModelRepository.findById(ad.getCarModel().getId()).orElseThrow(EntityNotFoundException::new);
    }

    public User getUser(Ad ad) {
        return userRepository.findById(ad.getUser().getId()).orElseThrow(EntityNotFoundException::new);
    }


}
