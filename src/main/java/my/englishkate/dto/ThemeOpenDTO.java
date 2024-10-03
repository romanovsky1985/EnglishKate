package my.englishkate.dto;

import lombok.Data;

@Data
public class ThemeOpenDTO {
    private Long id;
    private String title;
    private String instruction;
    private Long teacherId;
}
