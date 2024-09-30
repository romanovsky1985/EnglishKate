package my.englishkate.repository.mtm;

import my.englishkate.entity.mtm.StudentThemeMTM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentThemeMTMRepository extends JpaRepository<StudentThemeMTM, Long> {
}
