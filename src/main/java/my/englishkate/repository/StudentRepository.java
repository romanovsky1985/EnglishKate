package my.englishkate.repository;

import my.englishkate.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByUsername(String username);
}
