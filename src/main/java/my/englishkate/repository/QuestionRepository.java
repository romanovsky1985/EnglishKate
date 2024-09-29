package my.englishkate.repository;

import my.englishkate.model.QuestionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionModel, Long> {
}
