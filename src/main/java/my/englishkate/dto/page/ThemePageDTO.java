package my.englishkate.dto.page;

import lombok.Data;
import my.englishkate.dto.QuestionOpenDTO;

import java.util.List;

@Data
public class ThemePageDTO {
    private String themeTitle;
    private String themeInstruction;
    private Long themeId;

    private List<QuestionOpenDTO> questions;
}
