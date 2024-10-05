package my.englishkate.dto.page;

import lombok.Data;
import my.englishkate.dto.AnswerOpenDTO;

import java.util.List;

@Data
public class StudentAnswersPage {
    private String studentName;
    private Long studentId;
    private List<AnswerOpenDTO> answers;
}
