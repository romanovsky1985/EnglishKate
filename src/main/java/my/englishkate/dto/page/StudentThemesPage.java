package my.englishkate.dto.page;

import lombok.Data;
import my.englishkate.dto.ThemeOpenDTO;

import java.util.List;

@Data
public class StudentThemesPage {
    private String studentName;
    private Long studentId;

    private List<ThemeOpenDTO> teacherThemes;
    private List<ThemeOpenDTO> themes;
}
