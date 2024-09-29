package my.englishkate.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ThemeCreateDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String instruction;
}
