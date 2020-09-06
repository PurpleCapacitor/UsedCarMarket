package ucm.graphql;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.stereotype.Component;
import ucm.errors.ValidationError;
import ucm.models.User;
import ucm.models.UserType;
import ucm.repositories.UserRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    public User userLogin(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null) {
            return null; //TODO exceptions da je not found npr
        } else return user;
    }

    public String userRegistration(String username, String password, String repeatedPass) throws ValidationError {
        if(password.equals(repeatedPass)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setType(UserType.REGULAR);
            return userRepository.save(user).getUsername();
        } else throw new ValidationError("Passwords don't match.");
    }
}
