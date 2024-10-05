package my.englishkate.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnswerOpenDTO {
    private Long id;
    private Long studentId;
    private Long questionId;
    private String questionText;
    private String answerText;
    private Boolean result;
    private LocalDateTime createdAt;
}
