package footballmanager.dto.request;

import lombok.Data;

@Data
public class Transfer {
    private Long buyerId;
    private Long sellerId;
    private Long playerId;
}
