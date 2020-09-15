package ucm.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConditionInput {
    private boolean firstOwner;
    private boolean serviceHistory;
    private boolean spareKey;
    private boolean taxi;
}
