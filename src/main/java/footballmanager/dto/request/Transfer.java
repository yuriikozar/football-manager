package footballmanager.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Transfer {
    @NotNull
    @Min(value = 1)
    private Long buyerId;
    @NotNull
    @Min(value = 1)
    private Long sellerId;
    @NotNull
    @Min(value = 1)
    private Long playerId;
}
