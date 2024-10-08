package my.englishkate.repository;

import my.englishkate.entity.AnswerEntity;
import my.englishkate.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
    void deleteByStudent(StudentEntity student);
}
