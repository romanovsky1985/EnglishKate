package my.englishkate.entity;

import jakarta.persistence.*;
import lombok.Data;
import my.englishkate.entity.mtm.StudentThemeMTM;

import java.util.List;

@Entity
@Table(name = "themes")
@Data
public class ThemeEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String instruction;

    @OneToMany(mappedBy = "theme")
    private List<QuestionEntity> questions;

    @OneToMany(mappedBy = "theme")
    private List<StudentThemeMTM> students;

}
