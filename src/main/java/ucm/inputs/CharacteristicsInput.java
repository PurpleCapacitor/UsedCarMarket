package ucm.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ucm.models.Drivetrain;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacteristicsInput {
    private String emissionClass;
    private boolean ac;
    private String drivetrain;
    private String color;
    private String registeredUntil;
}
