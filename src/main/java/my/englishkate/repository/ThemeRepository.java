package my.englishkate.repository;

import my.englishkate.entity.ThemeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<ThemeEntity, Long> {
}
