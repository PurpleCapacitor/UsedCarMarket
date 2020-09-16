package ucm.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelInput {
    private String make;
    private String model;
    private int year;
    private int kilometers;
    private int displacement;
    private int hp;
}
