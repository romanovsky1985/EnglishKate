package my.englishkate.dto;

import lombok.Data;

@Data
public class PageQuestionDTO {
    private String title;
    private String instruction;
    private String text;
    private Long questionId;
}
