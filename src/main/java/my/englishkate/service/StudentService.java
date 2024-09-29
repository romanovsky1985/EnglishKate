package my.englishkate.service;

import my.englishkate.dto.StudentCreateDTO;
import my.englishkate.entity.StudentEntity;
import my.englishkate.mapper.StudentMapper;
import my.englishkate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements UserDetailsManager {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public StudentEntity getById(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow();
        return student;
    }

    public StudentEntity create(StudentCreateDTO createDTO) {
        StudentEntity student = studentMapper.map(createDTO);
        studentRepository.save(student);
        return student;
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
