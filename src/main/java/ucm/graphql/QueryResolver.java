package ucm.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import ucm.models.Ad;
import ucm.models.User;
import ucm.repositories.AdsRepository;
import ucm.repositories.CarModelRepository;
import ucm.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private AdsRepository adsRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Ad> getAds() {
        return adsRepository.findAll();
    }

    public Ad getAd(Long id) {
        return adsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Ad> getUserAds(String username) {
        User user = userRepository.findByUsername(username);
        return adsRepository.findByUser(user);
    }
}
