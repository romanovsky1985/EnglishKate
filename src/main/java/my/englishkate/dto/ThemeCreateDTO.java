package my.englishkate.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeCreateDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String instruction;
}
