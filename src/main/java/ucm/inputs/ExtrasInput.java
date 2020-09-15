package ucm.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExtrasInput {
    private boolean cruiseControl;
    private boolean electricalMirrors;
    private boolean electricalSeats;
    private boolean electricalWindows;
    private boolean multifunctionalSteeringWheel;
    private boolean bluetooth;
    private boolean ledHeadlights;
    private boolean heatedSeats;
}
