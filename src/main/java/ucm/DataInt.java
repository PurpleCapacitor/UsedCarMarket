package ucm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ucm.models.*;
import ucm.repositories.*;

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
    @Autowired
    private ExtrasRepository extrasRepository;


    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setUsername("a");
            user.setPassword("a");
            user.setType(UserType.REGULAR);
            userRepository.save(user);

            Extras extras = new Extras(true, true, true, true,
                    false, false, false, false, null
            );
            Extras extras2 = new Extras(false, true, false, true,
                    false, false, false, false, null
            );
            Extras extras3 = new Extras(true, true, true, true,
                    true, false, true, false, null
            );
            extrasRepository.save(extras);
            extrasRepository.save(extras2);
            extrasRepository.save(extras3);

            CarModel carModel = new CarModel();
            carModel.setMake("bmw");
            carModel.setModel("5er");
            carModel.setYear("2004");
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
            ad.setExtras(extras3);
            ad.setApproved(true);
            adsRepository.save(ad);

            CarModel carModel2 = new CarModel();
            carModel2.setMake("Mercedes");
            carModel2.setModel("E class");
            carModel2.setYear("2007");
            carModel2.setKilometers(10200);
            carModel2.setDisplacement(2201);
            carModel2.setHp(170);
            carModelRepository.save(carModel2);

            Characteristics characteristics2 = new Characteristics();
            characteristics2.setColor("red");
            characteristics2.setAc(true);
            characteristics2.setEmissionClass("Euro 5");
            characteristicsRepository.save(characteristics2);

            CarModel carModel3 = new CarModel();
            carModel3.setMake("Mercedes");
            carModel3.setModel("E class");
            carModel3.setYear("2006");
            carModel3.setKilometers(10200);
            carModel3.setDisplacement(2201);
            carModel3.setHp(170);
            carModelRepository.save(carModel3);

            Ad ad2 = new Ad();
            ad2.setCarModel(carModel);
            ad2.setUser(user);
            ad2.setDescription("blabla");
            ad2.setPhone("06542325");
            ad2.setAddress("Ep 7");
            ad2.setPrice(9000);
            ad2.setApproved(true);
            ad2.setCarModel(carModel2);
            ad2.setUser(user);
            ad2.setCharacteristics(characteristics2);
            ad2.setExtras(extras);
            adsRepository.save(ad2);

            Ad ad3 = new Ad();
            ad3.setCarModel(carModel);
            ad3.setUser(user);
            ad3.setDescription("nomnomnom");
            ad3.setPhone("08932325");
            ad3.setAddress("Ep 9");
            ad3.setPrice(7200);
            ad3.setCarModel(carModel3);
            ad3.setUser(user);
            ad3.setCharacteristics(characteristics2);
            ad3.setExtras(extras2);
            ad3.setApproved(true);
            adsRepository.save(ad3);
        }

    }
}
