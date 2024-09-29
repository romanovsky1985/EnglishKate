package my.englishkate.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCreateDTO {
    @NotBlank
    private String text;

    @NotNull
    private String answer;

    @NotNull
    private Long ThemeId;
}
