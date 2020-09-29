package ucm.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdsInput {
    private String description;
    private String address;
    private String phone;
    private int price;
    private Long imageId;
    /*private CarModelInput carModelInput;
    private UserInput userInput;
    private ExtrasInput extrasInput;
    private ConditionInput conditionInput;
    private CharacteristicsInput characteristicsInput;
    private SafetyInput safetyInput;*/
}
