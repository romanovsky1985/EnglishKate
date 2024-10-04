package my.englishkate.security;

import my.englishkate.service.StudentService;
import my.englishkate.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsManager {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return studentService.getByUsername(username);
        } catch (Exception ignored) {};
        try {
            return teacherService.getByUsername(username);
        } catch (Exception ignored) {};
        throw new UsernameNotFoundException(username);
    }

    @Override
    public void createUser(UserDetails userDetails) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateUser(UserDetails userDetails) {
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
