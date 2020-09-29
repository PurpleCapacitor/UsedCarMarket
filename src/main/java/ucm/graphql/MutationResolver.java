package ucm.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.checkerframework.checker.signature.qual.FieldDescriptorForPrimitiveOrArrayInUnnamedPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ucm.errors.ValidationError;
import ucm.inputs.*;
import ucm.models.*;
import ucm.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private AdsRepository adsRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private CharacteristicsRepository characteristicsRepository;
    @Autowired
    private ConditionRepository conditionRepository;
    @Autowired
    private ExtrasRepository extrasRepository;
    @Autowired
    private SafetyRepository safetyRepository;
    @Autowired
    private AdImageRepository adImageRepository;

    public User userLogin(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

    public String userRegistration(String username, String password, String repeatedPass) throws ValidationError {
        if (password.equals(repeatedPass)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setType(UserType.REGULAR);
            return userRepository.save(user).getUsername();
        } else throw new ValidationError("Passwords don't match.");
    }

    public Ad placeAd(AdsInput adsInput, CarModelInput carModelInput, UserInput userInput, ExtrasInput extrasInput,
                      ConditionInput conditionInput, CharacteristicsInput characteristicsInput, SafetyInput safetyInput) {

        Ad newAd = new Ad(adsInput);
        CarModel carModel = new CarModel(carModelInput);
        User user = userRepository.findByUsername(userInput.getUsername());
        Extras extras = new Extras(extrasInput);
        Condition condition = new Condition(conditionInput);
        Characteristics characteristics = new Characteristics(characteristicsInput);
        Safety safety = new Safety(safetyInput);
        AdImage image = adImageRepository.findById(adsInput.getImageId()).get();
        carModelRepository.save(carModel);
        extrasRepository.save(extras);
        conditionRepository.save(condition);
        characteristicsRepository.save(characteristics);
        safetyRepository.save(safety);

        newAd.setCarModel(carModel);
        newAd.setUser(user);
        newAd.setExtras(extras);
        newAd.setCondition(condition);
        newAd.setCharacteristics(characteristics);
        newAd.setSafety(safety);
        newAd.setImage(image);
        adsRepository.save(newAd);
        return newAd;

    }

    public int deleteAd(Long id) {
        adsRepository.deleteById(id);
        return id.intValue();
    }

    public int approveAd(Long id) {
        Ad ad = adsRepository.findById(id).get();
        ad.setApproved(true);
        adsRepository.save(ad);
        return id.intValue();
    }
}
