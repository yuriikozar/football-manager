package footballmanager.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TeamRequestDto {
    private String name;
    private int commission;
    private BigDecimal bank;
}
