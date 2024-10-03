package my.englishkate.service;

import my.englishkate.dto.TeacherCreateDTO;
import my.englishkate.entity.TeacherEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.mapper.TeacherMapper;
import my.englishkate.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ThemeService themeService;


    public TeacherEntity getById(Long id) {
        TeacherEntity teacher = teacherRepository.findById(id).orElseThrow();
        return teacher;
    }

    public TeacherEntity getByUsername(String username) {
        TeacherEntity teacher = teacherRepository.findByUsername(username).orElseThrow();
        return teacher;
    }

    public TeacherEntity create(TeacherCreateDTO createDTO) {
        TeacherEntity teacher = teacherMapper.map(createDTO);
        teacherRepository.save(teacher);
        return teacher;
    }

    public Long getCurrentTeacherId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication.getPrincipal() instanceof TeacherEntity)) {
            throw new RuntimeException("No authenticate teacher");
        }
        return ((TeacherEntity) authentication.getPrincipal()).getId();
    }

}
