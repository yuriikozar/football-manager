package footballmanager.dto.request;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeamRequestDto {
    @NotNull
    private String name;
    @NotNull
    @Min(value = 0)
    @Max(value = 10)
    private int commission;
    @NotNull
    @Min(value = 0)
    private BigDecimal bank;
}
