package my.englishkate.dto.page;

import lombok.Data;

@Data
public class TestPage {
    private String title;
    private String instruction;
    private String questionText;
    private Long questionId;
    private String studentName;
    private Long studentId;
    private Integer answersCount;
    private Integer wrongCount;
}
