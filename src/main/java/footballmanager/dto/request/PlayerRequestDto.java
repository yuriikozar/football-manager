package footballmanager.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerRequestDto {
    @NotNull
    private String name;
    @NotNull
    @Min(value = 1)
    private Long teamId;
    @NotNull
    @Min(value = 16)
    private int age;
    @NotNull
    @Min(value = 1)
    private int experience;
}
