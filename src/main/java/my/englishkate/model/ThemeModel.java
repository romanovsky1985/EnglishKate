package my.englishkate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "themes")
@Data
public class ThemeModel implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String instruction;

    @OneToMany(mappedBy = "theme")
    private List<QuestionModel> questions;
}
