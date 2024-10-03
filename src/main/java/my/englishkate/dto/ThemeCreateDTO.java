package my.englishkate.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeCreateDTO {
    @NotNull
    private Long teacherId;

    @NotBlank
    private String title;

    @NotBlank
    private String instruction;

}
