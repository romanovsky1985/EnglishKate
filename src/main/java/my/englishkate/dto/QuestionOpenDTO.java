package my.englishkate.dto;

import lombok.Data;

@Data
public class QuestionOpenDTO {
    private Long id;
    private String questionText;
    private String answerText;
}
