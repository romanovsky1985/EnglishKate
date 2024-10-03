package my.englishkate.repository;

import my.englishkate.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {
    Optional<TeacherEntity> findByUsername(String username);
}
