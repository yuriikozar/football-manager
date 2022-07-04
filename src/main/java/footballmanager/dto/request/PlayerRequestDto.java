package footballmanager.dto.request;

import lombok.Data;

@Data
public class PlayerRequestDto {
    private String name;
    private Long teamId;
    private int age;
    private int experience;
}
