package my.englishkate.repository;

import my.englishkate.model.ThemeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<ThemeModel, Long> {
}
