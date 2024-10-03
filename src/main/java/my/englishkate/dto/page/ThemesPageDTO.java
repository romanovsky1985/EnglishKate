package my.englishkate.dto.page;

import lombok.Data;
import my.englishkate.dto.ThemeOpenDTO;

import java.util.List;

@Data
public class ThemesPageDTO {
    private String teacherName;
    private Long teacherId;

    private List<ThemeOpenDTO> themes;
}
