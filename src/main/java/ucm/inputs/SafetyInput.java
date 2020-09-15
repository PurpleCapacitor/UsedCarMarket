package ucm.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SafetyInput {
    private boolean ABS;
    private boolean ESP;
    private boolean airbags;
    private boolean centralLocking;
    private boolean childLock;
}
