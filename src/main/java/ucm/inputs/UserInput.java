package ucm.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ucm.models.UserType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {
    private String username;
    private String password;
    private String type;
}
