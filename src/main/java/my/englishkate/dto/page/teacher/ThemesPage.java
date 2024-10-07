package my.englishkate.dto.page.teacher;

import lombok.Data;
import my.englishkate.dto.ThemeOpenDTO;

import java.util.List;

@Data
public class ThemesPage {
    private String teacherName;
    private Long teacherId;

    private List<ThemeOpenDTO> themes;
}
