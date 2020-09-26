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

    public User userLogin(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return null; //TODO exceptions da je not found npr
        } else return user;
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

    /*public String uploadImage(Part image, DataFetchingEnvironment environment) throws IOException {
        Part actualAvatar = environment.getArgument("image");
        BufferedImage actualImage = ImageIO.read(actualAvatar.getInputStream());
        BufferedImage scaledImage = scale(actualImage);
        String type = getType(actualAvatar.getContentType());
        File location = getLocation("foo." + type);
        ImageIO.write(scaledImage, type, location);
        return "http://localhost:8080/images/foo." + type;

    }

    private BufferedImage scale(BufferedImage image) {
        int maxWidth = 400;
        int maxHeight = 400;
        if (image.getWidth() >= image.getHeight() && image.getWidth() > maxWidth) {
            int newHeight = (int) (image.getHeight() * ((float) maxWidth / image.getWidth()));
            return getBuffered(image.getScaledInstance(maxWidth, newHeight, BufferedImage.SCALE_SMOOTH), maxWidth, newHeight);
        } else if (image.getHeight() > image.getWidth() && image.getHeight() > maxHeight) {
            int newWidth = (int) (image.getWidth() * ((float) maxHeight / image.getHeight()));
            return getBuffered(image.getScaledInstance(newWidth, maxHeight, BufferedImage.SCALE_SMOOTH), newWidth, maxHeight);
        } else {
            return image;
        }
    }

    private BufferedImage getBuffered(Image image, int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics().drawImage(image, 0, 0, null);
        return bufferedImage;
    }

    private String getType(String mimetype) {
        MediaType mediaType = MediaType.parseMediaType(mimetype);
        if (isJpeg(mediaType)) return "jpg";
        else if(isPng(mediaType)) return "png";
        else return mediaType.getSubtype();
    }

    private boolean isJpeg(MediaType mediaType) {
        return "jpeg".equalsIgnoreCase(mediaType.getSubtype());
    }

    private boolean isPng(MediaType mediaType) {
        return "png".equalsIgnoreCase(mediaType.getSubtype());
    }

    private File getLocation(String filename) throws IOException {
        File directory = resourceLoader.getResource("file:./filestorage/").getFile();
        return new File(directory, filename);
    }*/
}
