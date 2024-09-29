package my.englishkate.dto;

import lombok.Data;

@Data
public class QuestionOpenDTO {
    private Long id;
    private String text;
    private String answer;
    private Long themeId;
}
