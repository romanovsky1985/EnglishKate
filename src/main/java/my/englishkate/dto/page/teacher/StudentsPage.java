package my.englishkate.dto.page.teacher;

import lombok.Data;
import my.englishkate.dto.StudentOpenDTO;

import java.util.List;

@Data
public class StudentsPage {

    private List<StudentOpenDTO> students;
}
