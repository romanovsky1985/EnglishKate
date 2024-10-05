package my.englishkate.service;

import my.englishkate.dto.StudentCreateDTO;
import my.englishkate.entity.StudentEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.mapper.StudentMapper;
import my.englishkate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ThemeService themeService;


    public StudentEntity getById(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow();
        return student;
    }

    public StudentEntity getByUsername(String username) {
        StudentEntity student = studentRepository.findByUsername(username).orElseThrow();
        return student;
    }

    public StudentEntity create(StudentCreateDTO createDTO) {
        StudentEntity student = studentMapper.map(createDTO);
        studentRepository.save(student);
        return student;
    }

    public Long getCurrentStudentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication.getPrincipal() instanceof StudentEntity)) {
            throw new RuntimeException("No authenticate student");
        }
        return ((StudentEntity) authentication.getPrincipal()).getId();
    }

    public void addTheme(Long studentId, Long themeId) {
        StudentEntity student = studentRepository.findById(studentId).orElseThrow();
        ThemeEntity theme = themeService.getById(themeId);
        student.getThemes().add(theme);
        studentRepository.save(student);
    }

    public void removeTheme(Long studentId, Long themeId) {
        StudentEntity student = studentRepository.findById(studentId).orElseThrow();
        List<ThemeEntity> themes = student.getThemes();
        themes.stream()
                .filter(theme -> theme.getId() == themeId)
                .findFirst()
                .ifPresent(themes::remove);
        studentRepository.save(student);
    }
}
