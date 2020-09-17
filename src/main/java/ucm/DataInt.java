package ucm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ucm.models.*;
import ucm.repositories.AdsRepository;
import ucm.repositories.CarModelRepository;
import ucm.repositories.CharacteristicsRepository;
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
    @Autowired
    private CharacteristicsRepository characteristicsRepository;


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
            carModel.setYear(2004);
            carModel.setKilometers(10000);
            carModel.setDisplacement(2171);
            carModel.setHp(170);
            carModelRepository.save(carModel);

            Characteristics characteristics = new Characteristics();
            characteristics.setColor("blue");
            characteristics.setAc(true);
            characteristics.setEmissionClass("Euro 4");
            characteristicsRepository.save(characteristics);

            Ad ad = new Ad();
            ad.setCarModel(carModel);
            ad.setUser(user);
            ad.setDescription("blabla");
            ad.setPhone("06542325");
            ad.setAddress("Ep 7");
            ad.setPrice(4000);
            carModel.getAds().add(ad);
            user.getAds().add(ad);
            ad.setCharacteristics(characteristics);
            adsRepository.save(ad);


            CarModel carModel2 = new CarModel();
            carModel2.setMake("Mercedes");
            carModel2.setModel("E class");
            carModel2.setYear(2007);
            carModel2.setKilometers(10200);
            carModel2.setDisplacement(2201);
            carModel2.setHp(170);
            carModelRepository.save(carModel2);

            Characteristics characteristics2 = new Characteristics();
            characteristics2.setColor("red");
            characteristics2.setAc(true);
            characteristics2.setEmissionClass("Euro 5");
            characteristicsRepository.save(characteristics2);

            Ad ad2 = new Ad();
            ad2.setCarModel(carModel);
            ad2.setUser(user);
            ad2.setDescription("blabla");
            ad2.setPhone("06542325");
            ad2.setAddress("Ep 7");
            ad2.setPrice(9000);
            ad2.setCarModel(carModel2);
            ad2.setUser(user);
            ad2.setCharacteristics(characteristics2);
            adsRepository.save(ad2);
        }

    }
}
