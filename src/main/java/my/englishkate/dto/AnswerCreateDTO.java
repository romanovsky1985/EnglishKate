package my.englishkate.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCreateDTO {
    @NotNull
    private Long questionId;

    @NotNull
    private Long studentId;

    private String answerText;
}
