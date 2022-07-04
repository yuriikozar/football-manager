package footballmanager.dto.response;

import lombok.Data;

@Data
public class PlayerResponseDto {
    private Long id;
    private String name;
    private Long teamId;
    private int age;
    private int experience;
}
