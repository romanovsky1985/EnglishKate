package my.englishkate.entity.mtm;

import jakarta.persistence.*;
import lombok.Data;
import my.englishkate.entity.StudentEntity;
import my.englishkate.entity.ThemeEntity;

@Entity
@Table(name = "students_themes")
@Data
public class StudentThemeMTM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentEntity student;

    @ManyToOne
    private ThemeEntity theme;
}
