package ucm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ucm.models.Ad;
import ucm.models.CarModel;
import ucm.models.User;
import ucm.models.UserType;
import ucm.repositories.AdsRepository;
import ucm.repositories.CarModelRepository;
import ucm.repositories.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class DataInt implements CommandLineRunner {

    @Autowired
    private AdsRepository adsRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setUsername("a");
            user.setPassword("a");
            user.setType(UserType.REGULAR);
            userRepository.save(user);

            CarModel carModel = new CarModel();
            carModel.setMake("bmw");
            carModel.setModel("5er");
            carModel.setYear(LocalDate.parse("2004-01-01"));
            carModel.setKilometers(100);
            carModel.setDisplacement(2171);
            carModel.setHp(170);
            carModelRepository.save(carModel);

            Ad ad = new Ad();
            ad.setCarModel(carModel);
            ad.setUser(user);
            ad.setDescription("blabla");
            ad.setPhone("06542325");
            ad.setAddress("Ep 7");
            carModel.getAds().add(ad);
            user.getAds().add(ad);
            adsRepository.save(ad);
        }

    }
}
