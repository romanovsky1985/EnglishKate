package my.englishkate.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@Data
@EntityListeners(AuditingEntityListener.class)
public class AnswerEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    private QuestionEntity question;

    @ManyToOne
    private StudentEntity student;

    private String answerText;

    private Boolean result;

    @CreatedDate
    private LocalDateTime createdAt;
}
