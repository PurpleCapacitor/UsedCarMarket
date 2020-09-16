package ucm.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SafetyInput {
    @JsonProperty("ABS")
    private boolean ABS;
    @JsonProperty("ESP")
    private boolean ESP;
    private boolean airbags;
    private boolean centralLocking;
    private boolean childLock;
}
