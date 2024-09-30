package my.englishkate.service;

import my.englishkate.dto.StudentCreateDTO;
import my.englishkate.entity.StudentEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.entity.mtm.StudentThemeMTM;
import my.englishkate.mapper.StudentMapper;
import my.englishkate.repository.StudentRepository;
import my.englishkate.repository.mtm.StudentThemeMTMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService implements UserDetailsManager {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentThemeMTMRepository studentThemeMTMRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ThemeService themeService;


    public StudentEntity getById(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow();
        return student;
    }

    public StudentEntity create(StudentCreateDTO createDTO) {
        StudentEntity student = studentMapper.map(createDTO);
        studentRepository.save(student);
        return student;
    }

    public Long getCurrentStudentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        StudentEntity student = (StudentEntity) authentication.getPrincipal();
        System.out.println("DEBUGG: studentId = " + student.getId());
        return student.getId();
    }

    public void addTheme(Long studentId, Long themeId) {
        StudentEntity student = studentRepository.findById(studentId).orElseThrow();
        ThemeEntity theme = themeService.getById(themeId);
        StudentThemeMTM mtm = new StudentThemeMTM();
        mtm.setStudent(student);
        mtm.setTheme(theme);
        studentThemeMTMRepository.save(mtm);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public void updateUser(UserDetails userDetails) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createUser(UserDetails userDetails) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUser(String username) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean userExists(String username) {
        throw new UnsupportedOperationException();
    }
}
